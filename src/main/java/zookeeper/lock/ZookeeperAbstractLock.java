package zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;

//将重复的代码,体局业务逻辑由子类去实现
public abstract class ZookeeperAbstractLock implements Lock {
    private static final String CONNECT_ADDR = "192.168.181.129:2181";
    protected ZkClient zkClient = new ZkClient(CONNECT_ADDR);
    protected static final String PATH = "/lock";
    @Override
    public void getLock() {
        //tryLock() 创建zk临时节点 如果成功返回true 否则返回false
        if (tryLock()){
            System.out.println("获取到锁的资源");
        }else{
            //等待
            waitLock();
            //重新获取锁的资源
            getLock();
        }
    }

    protected abstract boolean tryLock();

    protected abstract void waitLock();

    @Override
    public void unLock() {
        if (zkClient != null){
            zkClient.close();
            System.out.println("释放锁资源");
        }
    }
}
