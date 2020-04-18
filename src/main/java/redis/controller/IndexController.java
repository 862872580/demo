package redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.service.RedisService;

import java.util.UUID;

@RestController
public class IndexController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("setToken")
    public String setToken(String value){
        String tokenKey = UUID.randomUUID() + "";
        redisService.setString(tokenKey,value ,20L);
        return tokenKey;
    }

    @RequestMapping("test")
    public String test(){
        for(int i = 0; i < 10; i++){
            String key = "redis." + i;
            redisService.setString(key, "1");
        }
        return "success";
    }

    @RequestMapping("getToken")
    public String getToken(String key){
        return (String) redisService.getString(key);
    }
}
