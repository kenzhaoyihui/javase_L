package library.library.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceConfiguration {

    @Bean
    public MyService service(ServiceProperties properties) {
        return new MyService(properties.getMessage());
    }
}