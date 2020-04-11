package activeMQ.producers;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//点对点
public class Producer {
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
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建一个队列
        Queue queue = session.createQueue(QUEUENAME);

        //创建一个生产者
        MessageProducer producer = session.createProducer(queue);

        //设置存放消息队列内容
        TextMessage textMessage = session.createTextMessage("hello world this is MQ");
        producer.send(textMessage);

        //session.commit();
        System.out.println("消息队列存放内容...成功...");

        session.close();
        connection.close();
    }
}
