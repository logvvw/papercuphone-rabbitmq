package net.logvv.papercuphone;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class ProducerMain {

    public static void main(String[] args) throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-main.xml");
        AmqpTemplate amqpTemplate = (AmqpTemplate) context.getBean("amqpTemplate");

        for(int i=0;i<30;i++){

            Map<String,Object> msg = new HashMap<>();
            msg.put("data","2018-12-17 mq test message " + i);

            amqpTemplate.convertAndSend("test_queueKey_01",msg);

            System.out.println("Send message #"+i);

            Thread.sleep(500);
        }

    }

}
