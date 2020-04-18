package Springboot_RabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DownCmdConsumer{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @RabbitListener(bindings = @QueueBinding(

            value = @Queue(), //注意这里不要定义队列名称,系统会随机产生

            exchange=@Exchange(value = "test_springboot", type = ExchangeTypes.FANOUT)
            )
        )

    public void process(String payload){
        logger.info("receive:{}" + payload);
        System.out.println("payload: " + payload);
    }
}