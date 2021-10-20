package com.hhh.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ConsumerKafkaStater {

    private static final String TOPIC = "test01";

    private static final String BROKER_LIST = "localhost:9092";

    private static final String GROUP_ID = "group.demo";


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();

        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        properties.put("bootstrap.servers",BROKER_LIST);

        properties.put("group.id",GROUP_ID);



        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(properties);
        //订阅主题
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC));

        //获取消息
        while (true){
            ConsumerRecords<String, String> poll = kafkaConsumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord record : poll){
                System.out.println(record.value());
            }
        }

    }
}
