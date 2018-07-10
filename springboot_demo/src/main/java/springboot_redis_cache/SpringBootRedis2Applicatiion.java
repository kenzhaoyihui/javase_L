package springboot_redis_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringBootRedis2Applicatiion {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedis2Applicatiion.class, args);
    }
}
