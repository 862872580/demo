package myredis.app;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class ScheduledTasks {

    //每隔多久
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void add(){
        System.out.println("我正在执行.." + System.currentTimeMillis());
        //执行删除操作
        remove();
    }

    public void remove(){

    }
}
