package redis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"redis.controller.controller", "redis.service.service"})
@EnableAutoConfiguration
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }
}
