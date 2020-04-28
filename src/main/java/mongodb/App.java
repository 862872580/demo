package mongodb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("mongodb")
@MapperScan("mongodb.repository")
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class);

    }
}
