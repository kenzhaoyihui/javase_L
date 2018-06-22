package com.example.bean;

public class JsonResult {

    private String status = null;

    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
