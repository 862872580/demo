package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

//操作zookeeper
public class ZookeeperDemo {
    private static final String CONNECT_ADDR = "192.168.181.129:2181";
    private static final Integer SESSION_TIME = 2000;
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_TIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //获取时间的状态
                Event.KeeperState keeperState = watchedEvent.getState();
                Event.EventType eventType = watchedEvent.getType();
                //如果建立连接
                if(Event.KeeperState.SyncConnected == keeperState){
                    if (Event.EventType.None == eventType){
                        System.out.println("zk 建立连接");
                        //zk连接成功后,放行,唤醒其他线程执行
                        countDownLatch.countDown();
                    }
                }
            }
        });
        //让主线程等待
        countDownLatch.await();
        System.out.println("开始建立zk节点..");
        String result = zk.create("/parent2","son2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建zk节点成功..." + result);
        zk.close();
    }
}
