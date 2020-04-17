package myredis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan({"myredis.app"})
@EnableScheduling //开启定时任务注解
@EnableAutoConfiguration
public class RedisApp {

    public static void main(String[] args) {

        SpringApplication.run(RedisApp.class);

    }
}
