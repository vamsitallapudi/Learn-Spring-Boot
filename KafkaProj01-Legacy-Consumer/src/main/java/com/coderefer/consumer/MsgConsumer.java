package com.coderefer.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class MsgConsumer {
    public static void main(String[] args) {
        //    create connection properties as K=V in java.util.properties class obj
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1_consumers");
//        create Kafka Producer object
        KafkaConsumer<String, String> c = new KafkaConsumer<>(props);
//        Subscribe to topic destination through Message Broker
        String topicName = "coderefer-topic";
        c.subscribe(Collections.singletonList(topicName));
//        Perform polling to check and read the messages
        while (true) {
            ConsumerRecords<String, String> records = c.poll(Duration.ofMillis(2000));
            for(ConsumerRecord<String, String> r : records) {
                System.out.println(r.value());
            }
        }
    }
}
