package com.yzhao.jsonrpc.enitity;

public class HelloWorldServiceImpl implements HelloWorldService {

    int count = 0;

    @Override
    public HelloWorldBean getDemonBean(String code, String msg) {
        //return null;
        System.out.println("HelloWorldBean get");

        HelloWorldBean bean = new HelloWorldBean();
        bean.setCode(Integer.parseInt(code));
        bean.setMsg(msg + " , javaBean is fine! ");

        return bean;

    }

    @Override
    public Integer getInt(Integer code) {
        //return null;
        return code + count;
    }

    @Override
    public String getString(String msg) {
        //return null;
        return msg + ", server is fine!";
    }

    @Override
    public void doSomething() {
        count++;
        System.out.println("Do something" + "; count => " + count);
    }
}
