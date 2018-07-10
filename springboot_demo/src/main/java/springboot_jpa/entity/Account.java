package springboot_jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private double money;

    public Account() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Account{" +
                " id=" + id +
                ", name=" + name +
                ", money=" + money +
                "}";
    }
}
