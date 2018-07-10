package springboot_3_valdating_form_input.domain;

//import org.hibernate.validator.constraints.NotEmpty;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Entity should use with @Id
 */

@Entity
public class User implements Serializable {

    /**
     * Id
     */
    @Id
    @GeneratedValue
    private Long id;


    /**
     * Name
     */
    @NotEmpty(message = "Name is not empty")
    @Size(min = 2, max = 8, message = "The name length is 2~8")
    private String name;


    /**
     * Age
     */
    @NotNull(message = "The age is not empty")
    @Min(value = 0, message = "the age is larger than 0")
    @Max(value = 80, message = "the age is smaller than 80")
    private Integer age;


    /**
     * Bitrh time
     */
    @NotEmpty(message = "The birthday is not empty")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", birthday=" + birthday +
                "}";
    }
}
