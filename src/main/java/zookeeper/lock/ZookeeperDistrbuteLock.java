package zookeeper.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock{
    private CountDownLatch countDownLatch = null;
    @Override
    protected boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    protected void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            //节点被删除的时候事件通知
            @Override
            public void handleDataChange(String path, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String path) throws Exception {
                //唤醒
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };

        //注册到zkClient进行监听
        zkClient.subscribeDataChanges(PATH,iZkDataListener);
            if (zkClient.exists(PATH)){
                    countDownLatch = new CountDownLatch(1);
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            zkClient.unsubscribeDataChanges(PATH,iZkDataListener);
    }

}
