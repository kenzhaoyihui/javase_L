package com.yzhao.jsonrpc.enitity;

public interface HelloWorldService {

    HelloWorldBean getDemonBean(String code, String msg);

    Integer getInt(Integer code);

    String getString(String msg);

    void doSomething();
}
