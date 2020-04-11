package activeMQ.receivers;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//点对点
public class Receiver {
    private static final String USERNAME="admin";
    private static final String PASSWORD="admin";
    private static final String BROKERURL="tcp://127.0.0.1:61616";
    private static final String QUEUENAME="myQueue";

    public static void main(String[] args) {
        try {
            start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    static public void start() throws JMSException {
        //获取ActiveMQ会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
        Connection connection = activeMQConnectionFactory.createConnection();

        //启动连接
        connection.start();

        //jms 设置消息可靠性 自动签收
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUENAME);

        //创建一个消费者
        MessageConsumer consumer = session.createConsumer(queue);

        //等待消息
        while(true) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            if (textMessage != null){
                System.out.println("我是消费者,内容:" + textMessage.getText());
                //session.commit();
                //手动应答
                textMessage.acknowledge();
            }else {
                break;
            }
        }
        session.close();
        connection.close();
    }
}
