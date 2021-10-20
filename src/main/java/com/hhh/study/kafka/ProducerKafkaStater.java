package com.hhh.study.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerKafkaStater {

    private static final String TOPIC = "test01";

    private static final String BROKER_LIST = "localhost:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();

        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");

        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        properties.put("bootstrap.servers",BROKER_LIST);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        //构建发送的消息

        ProducerRecord producerRecord = new ProducerRecord(TOPIC, "Hello, Kafka!");

        Future send = kafkaProducer.send(producerRecord);

        System.out.println(send.get());

        kafkaProducer.close();
    }
}
