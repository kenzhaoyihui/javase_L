package springboot_1_config.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "demo.book")
@Validated
public class BookComponent {


    @NotEmpty
    private String name;


    @NotNull
    private String writer;

    public String getWriter() {
        return writer;
    }

    public String getName() {
        return name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
