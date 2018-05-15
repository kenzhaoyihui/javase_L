package yzhao.spring.io.SpEL1;

import org.springframework.beans.factory.annotation.Value;

public class Customer {
    @Value("#{item}")
    private Item item;

    @Value("#{item.name}")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
