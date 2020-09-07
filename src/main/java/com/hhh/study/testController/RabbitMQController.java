package com.hhh.study.testController;


import com.hhh.study.My异步转同步.DefaultFuture;
import com.hhh.study.rabbitMQ.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class RabbitMQController {

    @Autowired
    QueueSender queueSender;


    @RequestMapping("/sendMQ/{msg}")
    public String rabbitMQTest(@PathVariable("msg") String msg){

        queueSender.sendMsg(msg);
        return "向MQ中发送消息: "+ msg;

    }

    @RequestMapping("/get/{id}/{timeOut}")
    public String get(@PathVariable("id") String id,@PathVariable("timeOut") String timeOut){

        System.out.println("id:"+id+",timeOut:"+timeOut);
        DefaultFuture defaultFuture = new DefaultFuture(id,Integer.parseInt(timeOut));
        Object o = null;
        try{
            o = defaultFuture.tryGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("请求超时,ID:"+id);
        }

        return (String)o;

    }


    @RequestMapping("/set/{id}/{msg}")
    public void set(@PathVariable("id") String id, @PathVariable("msg") String msg){

        DefaultFuture.received(id,msg);

    }
}
