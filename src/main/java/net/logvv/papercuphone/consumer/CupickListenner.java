package net.logvv.papercuphone.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * CupickListenner
 *
 * @author willie
 * @date 2018-12-28 10:32
 */
public class CupickListenner implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try{
            String body=new String(message.getBody(),"UTF-8");
            System.out.println("[cupick listener] received: "+body);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
