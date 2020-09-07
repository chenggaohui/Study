package com.hhh.study.My异步转同步;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class Test {


//    @RequestMapping("/get")
//    public String get(@PathParam("id") String id,@PathParam("timeOut") String timeOut){
//
//        System.out.println("id:"+id+",timeOut:"+timeOut);
//        DefaultFuture defaultFuture = new DefaultFuture(id,Integer.parseInt(timeOut));
//        Object o = null;
//        try{
//            o = defaultFuture.tryGet();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//            System.out.println("请求超时,ID:"+id);
//        }
//
//        return (String)o;
//
//    }
//
//
//    @RequestMapping("/set")
//    public void set(@PathParam("id") String id,@PathParam("msg") String msg){
//
//        DefaultFuture.received(id,msg);
//
//    }
}
