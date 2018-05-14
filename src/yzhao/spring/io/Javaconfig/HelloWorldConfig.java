package yzhao.spring.io.Javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld(){
        System.out.println("Creating a HelloWorld instance...");
        return new HelloWorld();
    }
}
