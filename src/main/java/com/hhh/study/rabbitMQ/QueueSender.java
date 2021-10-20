package com.hhh.study.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String msg){
        amqpTemplate.convertAndSend("directQueue",msg);
    }
}
