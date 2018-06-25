package springboot_2_web.bean;

import java.io.Serializable;

public class Book implements Serializable {

    private Long id;

    private String name;

    private String writer;

    private String introduction;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public String getIntroduction() {
        return introduction;
    }
}
