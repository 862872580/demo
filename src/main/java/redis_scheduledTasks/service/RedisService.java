package redis_scheduledTasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
