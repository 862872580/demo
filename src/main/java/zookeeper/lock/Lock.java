package zookeeper.lock;

public interface Lock {
    //上锁
    public void getLock();
    //解锁
    public void unLock();
}
