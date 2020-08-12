package com.hhh.study.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directQueue")
public class QueueListener {

    @RabbitHandler
    public void directQueueHandler1(String msg){
        System.out.println("队列: directQueue1 ----> 收到消息为: "+msg.toString());
    }
    
}
