package com.hhh.study;

import com.hhh.study.rabbitMQ.QueueSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class StudyApplicationTests {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    QueueSender queueSender;

    @Test
    void contextLoads() throws InterruptedException {

//        while(true){
//            String msg = scanner.nextLine();
//            if ("quit".equals(msg)||"exit".equals(msg)){
//                break;
//            }
//            queueSender.sendMsg(msg);
//        }
//        queueSender.sendMsg("困了!!!!");



    }

}
