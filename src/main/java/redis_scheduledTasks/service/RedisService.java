package redis_scheduledTasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存放数据到redis
     * @param key
     * @param value
     */
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

    /**
     * 获取redis中以某字符串为前缀的KEY列表代码
     */
    public Set<String> selectAll(RedisTemplate redisTemplate, String s) {
        Set<String> keys = redisTemplate.keys(s);
        return keys;
    }

    /**
     * 模糊查询出的key的集合
     */
    public void remove(RedisTemplate redisTemplate, String s){
        Set<String> set = selectAll(redisTemplate, s);
        deleteSet(redisTemplate, set);
    }

    /**
     * 批量删除
     * @param redisTemplate 数据源
     * @param set 模糊查询出的key的集合
     */
    private void deleteSet(RedisTemplate redisTemplate, Set<String> set) {
        redisTemplate.delete(set);
    }
}
