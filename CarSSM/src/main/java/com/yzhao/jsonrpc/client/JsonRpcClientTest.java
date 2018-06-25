package com.yzhao.jsonrpc.client;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.yzhao.jsonrpc.enitity.HelloWorldBean;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JsonRpcClientTest {

    static JsonRpcHttpClient client;
    public JsonRpcClientTest() {}

    public static void main(String[] args) throws Throwable {
        try{
            client = new JsonRpcHttpClient(new URL(
                    "http://127.0.0.1:8888/rpc"
            ));

            Map<String, String> headers = new HashMap<>();
            headers.put("Name", "Key");

            client.setHeaders(headers);

            JsonRpcClientTest test = new JsonRpcClientTest();

            HelloWorldBean demo = test.getDemon(1, "haha");

            System.out.println("+++++++++++++javabean");
            System.out.println(demo.getCode());
            System.out.println(demo.getMsg());

            int code = test.getInt(10);
            System.out.println("+++++++++++++++Integer first");
            System.out.println(code);

            test.doSomething();

            code = test.getInt(10);
            System.out.println("+++++++++++++Integer second");
            System.out.println(code);

            String msg = test.getString("zyhzyh");
            System.out.println("+++++++++++++String");
            System.out.println(msg);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doSomething() throws Throwable{
        client.invoke("doSomething", null);
    }

    public HelloWorldBean getDemon(int code, String msg) throws Throwable {
        String[] params = new String[] {String.valueOf(code), msg};
        HelloWorldBean demo = null;

        demo = client.invoke("getDemonBean", params, HelloWorldBean.class);

        return demo;
    }

    public int getInt(int code) throws Throwable {
        Integer[] params = new Integer[] {code};
        return client.invoke("getInt", params, Integer.class);
    }

    public String getString(String msg) throws Throwable {
        String[] params = new String[] {msg};
        return client.invoke("getString", params, String.class);
    }

}
