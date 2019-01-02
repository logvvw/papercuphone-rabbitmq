package net.logvv.papercuphone.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class MQReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MQReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 描述：注解方式配置异步接受消息 @RabbitListener </br>
     * 需要配置 配置@EnableRabbit rabbitListenerContainerFactory
     * @param
     * @author willie
     * @date 2018/12/28 14:13
     */
    @RabbitListener(queues = "test_queue_01")
    public void receiveMessage(Message msg) {

        String body=new String(msg.getBody());

        System.out.println("[annotation method] received: <" + body + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
