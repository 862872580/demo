package com.itmayiedu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan({"com.itmayiedu.controller"
        , "com.itmayiedu.service"
        , "com.itmayiedu.app"})
@MapperScan("com.itmayiedu.dao")
@EnableCaching //开启缓存注解
@EnableScheduling //开启定时任务注解
@EnableAsync //开启异步注解
@EnableAutoConfiguration
public class app {

    public static void main(String[] args) {

        SpringApplication.run(app.class);

    }
}
