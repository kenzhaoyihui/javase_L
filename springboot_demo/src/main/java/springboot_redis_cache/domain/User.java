package springboot_redis_cache.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

//@Entity
public class User {

//    @Id
//    @GeneratedValue
    private String id;
    private String name;
    private String age;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "User [id=" + id +
                ", name=" + name +
                ", age=" + age +
                "]";
    }
}
