package com.yzhao.pojo;

public class Order {
    private int orderId;
    private String orderNo;
    private float money;
    private int userId;
    private User user;

    public int getOrderId() {
        return orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public float getMoney() {
        return money;
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
