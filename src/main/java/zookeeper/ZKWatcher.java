package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZKWatcher implements Watcher {
    private static final String CONNECT_ADDR = "192.168.181.129:2181";
    private static final Integer SESSION_TIME = 2000;
    private ZooKeeper zooKeeper;


    public ZKWatcher() {
        createConnection(CONNECT_ADDR, SESSION_TIME);
    }

    //zk节点 发生变更、删除、修改、新增
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState keeperState = watchedEvent.getState();
        Event.EventType eventType = watchedEvent.getType();
        String path = watchedEvent.getPath();
        if (keeperState.SyncConnected == keeperState){
            //连接类型
            if (eventType.None == eventType){
                //建立zk连接
                System.out.println("建立zk连接成功");
            }
            //创建
            if (eventType.NodeCreated == eventType){
                System.out.println("####当前创建一个的节点####路径:" + path);
            }
            //修改
            if (eventType.NodeDataChanged == eventType){
                System.out.println("####当前修改一个的节点####路径:" + path);
            }
            //删除
            if (eventType.NodeDeleted == eventType){
                System.out.println("####当前删除一个的节点####路径:" + path);
            }
        }
    }

    //创建zk连接
    public void createConnection(String path, int sessionTimeout){
        try {
            zooKeeper = new ZooKeeper(path, sessionTimeout, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建节点
    public void createNode(String path,String data){
        try {
            String result = zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建节点成功... result:" + result);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //修改节点
    public void updateNode(String path, String data){
        try {
            zooKeeper.setData(path,data.getBytes(), -1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //删除节点
    public void deleteNode(String path, String data){
        try {
            zooKeeper.delete(path, -1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if (zooKeeper != null) {
                zooKeeper.close();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZKWatcher zkWatcher = new ZKWatcher();
        zkWatcher.createNode("/parent/son6","123");
        zkWatcher.close();
    }
}
