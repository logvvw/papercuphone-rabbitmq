package net.logvv.papercuphone.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListenner implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try{
            String body=new String(msg.getBody(),"UTF-8");
            System.out.println("[queue listener] received: "+body);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
