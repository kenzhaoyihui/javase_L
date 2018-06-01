package memcachedtest;

import javaioexample.aio.client.Client;
import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

class client{
    private final int expiredSeconds = 100;

    private final InetSocketAddress server = new InetSocketAddress("127.0.0.1", 11211);

    private MemcachedClient memcachedClient;

    public void init(){
        try{
            memcachedClient = new MemcachedClient(server);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void put(String key, Object obj){
        memcachedClient.set(key, expiredSeconds, obj);
    }

    public Object get(String key){
        return memcachedClient.get(key);
    }


    public void delete(String key){
        memcachedClient.delete(key);
    }
}

public class testmemcached1 {
    public static void main(String[] args) {

        client client1 = new client();
        client1.init();

        long begin = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            client1.put(i + "", i);
            System.out.println(client1.get(i+""));
        }

        long end = System.currentTimeMillis();
        System.out.println((end-begin) + " ms");
    }
}