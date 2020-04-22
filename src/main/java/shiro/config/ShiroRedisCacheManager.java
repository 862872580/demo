package shiro.config;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * shiro扩展使用redis管理缓存
 */
public class ShiroRedisCacheManager extends AbstractCacheManager {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected Cache createCache(String name) throws CacheException {
        return new ShiroRedisCache(redisTemplate, name);
    }
}
