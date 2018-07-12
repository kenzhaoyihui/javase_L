package springboot_handle_form.springboot_handle_form.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Greeting {

    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Greeting [" +
                " Id=" + id +
                ", Content=" + content +
                "]";
    }
}
