import net.logvv.papercuphone.service.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-main.xml"})

public class MQTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(MQTest.class);

    @Autowired
    MQProducer mqProducer;

    final String queueKey_name = "test_queueKey_01";

    @Test
    public void send() throws Exception{

        for(int i=0;i<20;i++){

            Map<String,Object> msg = new HashMap<>();
            msg.put("data","2018-12-17 mq test message " + i);

            mqProducer.sendDataToQueue(queueKey_name,msg);

            LOGGER.info("send msg #{} to {}",i,queueKey_name);

//            Thread.sleep(500);

        }
    }
}