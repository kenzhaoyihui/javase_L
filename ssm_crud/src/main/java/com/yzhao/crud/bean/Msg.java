package com.yzhao.crud.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    //status code, 100, 200...
    private int code;

    private String msg;

    private Map<String, Object> extend = new HashMap<>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("Success");
        return result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(404);
        result.setMsg("Fail");
        return result;
    }

    public Msg add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
