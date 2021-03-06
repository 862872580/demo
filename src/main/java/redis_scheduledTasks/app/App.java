package redis_scheduledTasks.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("redis_scheduledTasks")
@EnableScheduling //开启定时任务注解
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class);

    }
}
