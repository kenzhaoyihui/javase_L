package memcachedtest;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.GetFuture;
import net.spy.memcached.internal.OperationFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Id: " + this.id + ", Name: " + this.name + " ,Age: " + this.age;
    }
}


public class testMemcached2 {

    MemcachedClient client = null;

    @Before
    public void before(){
        try{
            System.out.println("Before");
            client = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @After
    public void after(){
        System.out.println("After");
        client.shutdown();

    }

    @Test
    public void get(){
        try{
            client.add("name", 60, "yzhao");
            System.out.println(client.get("name"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserList(){

        //实体类需要序列化
        try{
            User user1 = new User();
            user1.setId(1L);
            user1.setName("yzhao");
            user1.setAge(23);

            User user2 = new User();
            user2.setId(2L);
            user2.setName("lj");
            user2.setAge(22);

            List<User> list = new ArrayList<>();
            list.add(user1);
            list.add(user2);

            client.add("userList", 60, list);

            List<User> newList = (List<User>) client.get("userList");
            if(newList!=null&&newList.size()>0){
                for(User user: newList){
                    System.out.println(user.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void asyncGet(){
        client.set("name", 60, "ljhah");

        //异步获取
        GetFuture<Object> future = client.asyncGet("name");

        try{
            //f.get的参数是指获取数据的时间上限，如果超出该时间，则会抛出异常。
            System.out.println(future.get(5, TimeUnit.SECONDS));
        }catch (InterruptedException e){
            //没有catch到异常,则可以取消这次请求。
            future.cancel(true);
            System.out.println(e.getMessage());
        }catch (ExecutionException e){
            future.cancel(true);
            System.out.println(e.getMessage());
        }catch (TimeoutException e){
            future.cancel(true);
            System.out.println(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void retry(String key, String value, int type){

        CASValue<Object> casValue = client.gets(key);
        System.out.println(casValue.getCas() + "------" + casValue.getValue());

        CASResponse casResponse = null;
        if(type==1){
            //覆蓋值
            casResponse = client.cas("title", casValue.getCas(), value);
        }else  if(type==2){
            //追加值
            casResponse = client.cas("title", casValue.getCas(), casValue.getValue() + " " + value);
        }

        if (casResponse.toString().equals("OK")){
            CASValue<Object> casValue1 = client.gets("title");
            System.out.println(casValue1.getCas() + "------" + casValue1.getValue());
        }else{
            retry(key, value, type);
        }
    }


    @Test
    public void cas(){
        try{
            client.set("title", 60, "hello");
            retry("title", "world", 2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void append(){
        try{
            client.set("content",60,"hello");
            CASValue<Object> casValue=client.gets("content");
            OperationFuture<Boolean> operationFuture=client.append(casValue.getCas(),"content"," world");
            System.out.println(operationFuture.get()+"---"+operationFuture.getKey()+"---"+operationFuture.getStatus().isSuccess()+"---"+operationFuture.isDone());
            if(!operationFuture.get().equals(true)){
                append();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void asyncCAS(){
        try{
            client.set("asynccas",60,"hello");
            CASValue<Object> casValue=client.gets("asynccas");
            System.out.println(casValue.getCas()+"---"+casValue.getValue());
            Future<CASResponse> future= client.asyncCAS("asynccas",casValue.getCas(),"hi");
            CASResponse casResponse=future.get();
            System.out.println(casResponse.toString());
            if(!casResponse.toString().equals("OK")){
                asyncCAS();
            }else{
                casValue=client.gets("asynccas");
                System.out.println(casValue.getCas()+"---"+casValue.getValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void decr(){
        try{
            client.set("age", 60, "30");
            CASValue<Object> casValue = client.gets("age");
            System.out.println(casValue.getCas()+ "--" + casValue.getValue());

            client.decr("age", 5);
            casValue = client.gets("age");
            System.out.println(casValue.getCas() + "---" + casValue.getValue());

            client.decr("age", 3, 4L);
            casValue = client.gets("age");
            System.out.println(casValue.getCas() + "----" + casValue.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void asyncDecr(){
        try{
            client.set("age",60,"30");
            OperationFuture<Long> operationFuture=client.asyncDecr("age",5);
            System.out.println(operationFuture.get()+"---"+operationFuture.getKey()+"---"+operationFuture.getStatus().isSuccess()+"---"+operationFuture.isDone());
            if(!operationFuture.getStatus().isSuccess()){
                asyncDecr();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void incr(){
        try{
            //注意值需为String类型，如何为int类型会将其转化为字符串，不能调用incr decr方法。
            client.set("age",60,"30");
            CASValue<Object> casValue=client.gets("age");
            System.out.println(casValue.getCas()+"--"+casValue.getValue());
            //值必須大於等於0，否則會報invalid numeric delta argument
            //client.incr("age",-5);
            client.incr("age",5);
            casValue=client.gets("age");
            System.out.println(casValue.getCas()+"--"+casValue.getValue());
            //第三個為def，如果incr操作失敗，則將def的值加到value上。
            client.incr("age",3,4L);
            casValue=client.gets("age");
            System.out.println(casValue.getCas()+"--"+casValue.getValue());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void asyncIncr(){
        try{
            client.set("age",60,"30");
            OperationFuture<Long> operationFuture=client.asyncIncr("age",5);
            System.out.println(operationFuture.get()+"---"+operationFuture.getKey()+"---"+operationFuture.getStatus().isSuccess()+"---"+operationFuture.isDone());
            if(!operationFuture.getStatus().isSuccess()){
                asyncIncr();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void prepend(){
        try{
            client.set("prepend",60," world");
            CASValue<Object> casValue=client.gets("prepend");
            OperationFuture<Boolean> operationFuture=client.prepend(casValue.getCas(),"prepend","hello");
            casValue=client.gets("prepend");
            System.out.println(casValue.getValue());
            if (!operationFuture.get().equals(true)) {
                prepend();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void flush(){
        try{
            client.set("flush",60,"hello");
            //清除服務器所有緩存
            client.flush();
            //在10秒后清除服務器所有緩存
//            client.flush(10);
            CASValue<Object> casValue=client.gets("flush");
            System.out.println(casValue==null);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void getBulk(){
        try{
            client.set("bulk1",60,"111");
            client.set("bulk2",60,"222");
            client.set("bulk3",60,"333");
            List<String> keyList=new ArrayList<String>();
            keyList.add("bulk1");
            keyList.add("bulk2");
            keyList.add("bulk3");
            Map<String,Object> map=client.getBulk(keyList);
            if(map!=null){
                Set<String> keySet=map.keySet();
                for(String key:keySet){
                    System.out.println(key+"---"+map.get(key));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
