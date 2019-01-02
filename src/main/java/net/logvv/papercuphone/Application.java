package net.logvv.papercuphone;
/**
 * Author: wangwei
 * Created on 2016/12/16 11:11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableRabbit
@EnableAutoConfiguration
@ImportResource("classpath:spring-main.xml")
@EnableAsync
@EnableScheduling
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException
    {
        SpringApplication.run(Application.class, args);

        LOGGER.info("Begin to run papercuphone !");

    }

}
