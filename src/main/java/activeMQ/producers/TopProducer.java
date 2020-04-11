package activeMQ.producers;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//发布订阅
public class TopProducer {
    private static final String USERNAME="admin";
    private static final String PASSWORD="admin";
    private static final String BROKERURL="tcp://127.0.0.1:61616";
    private static final String TOPICNAME="myTopic";

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

        //创建一个主题
        Topic topic = session.createTopic(TOPICNAME);

        //创建一个生产者
        MessageProducer producer = session.createProducer(topic);

        //设置存放消息队列内容
        TextMessage textMessage = session.createTextMessage("hello world this is MQ");
        producer.send(textMessage);

        //session.commit();
        System.out.println("消息队列存放内容...成功...");

        session.close();
        connection.close();
    }
}
