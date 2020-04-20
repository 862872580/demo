package redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    public void setString(String key, Object value){
        set(key,value,null);
    }

    public void setString(String key, Object value, Long timeout){
        set(key,value,timeout);
    }

    public void set(String key, Object value, Long timeout){
        if (value == null){
            return;
        }
        if(value instanceof String){
            stringRedisTemplate.opsForValue().set(key, (String) value);
            if (timeout != null) {
                stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
        }
    }

    public Object getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }


}
