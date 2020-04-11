package zookeeper.lock;

//订单服务
public class OrderService implements Runnable{
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    private Lock lock = new ZookeeperDistrbuteLock();
    @Override
    public void run() {
        getNumber();
    }

    public void getNumber() {
        lock.getLock();
        String number = orderNumGenerator.orderNumber();
        System.out.println("生成订单号:" + number);
        lock.unLock();
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            new Thread(new OrderService()).start();
        }
    }
}
