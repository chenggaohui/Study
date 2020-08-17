package com.hhh.study.testController;


import com.hhh.study.rabbitMQ.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    QueueSender queueSender;


    @RequestMapping("/sendMQ/{msg}")
    public String rabbitMQTest(@PathVariable("msg") String msg){

        queueSender.sendMsg(msg);
        return "向MQ中发送消息: "+ msg;

    }
}
