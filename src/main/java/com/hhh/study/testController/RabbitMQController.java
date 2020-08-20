package com.hhh.study.testController;


import com.hhh.study.rabbitMQ.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RabbitMQController {

    @Autowired
    QueueSender queueSender;


    @RequestMapping("/sendMQ/{msg}")
    public String rabbitMQTest(@PathVariable("msg") String msg){

        queueSender.sendMsg(msg);
        return "向MQ中发送消息: "+ msg;

    }

    public static void main(String[] args) {
        Map<String,String> map =new HashMap<>(3);
        map.put("1","2");
        System.out.println("111");
    }
}
