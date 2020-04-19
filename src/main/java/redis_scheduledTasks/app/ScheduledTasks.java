package redis_scheduledTasks.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis_scheduledTasks.service.RedisService;

import javax.annotation.Resource;

@Component
public class ScheduledTasks {

    @Autowired
    RedisService redisService;


    @Resource(name = "redisTemplate0")
    private StringRedisTemplate redisTemplate0;

    @Resource(name = "redisTemplate1")
    private StringRedisTemplate redisTemplate1;

    /**
     * 00:00定时任务批量删除
     */
    //@Scheduled(cron = "0 0 0 */1 * ?")
    @Scheduled(fixedRate = 2000)
    public void remove(){

        //以redis.为前缀
        String s = "redis.*";
        //数据源删除
        redisService.remove(redisTemplate0, s);
        redisService.remove(redisTemplate1, s);

    }

}
