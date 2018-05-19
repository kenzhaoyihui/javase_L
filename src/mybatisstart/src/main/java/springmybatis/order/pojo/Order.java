package springmybatis.order.pojo;

import java.util.*;

/**
 * @author yzhao_sherry
 * @version v1.0
 * @copyright redhat
 */

public class Order {
    private int orderId;
    private String orderNo;
    private float money;
    private int useId;
    private User user;

    public User getUser() {
        return user;
    }

    public float getMoney() {
        return money;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUseId() {
        return useId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }
}
