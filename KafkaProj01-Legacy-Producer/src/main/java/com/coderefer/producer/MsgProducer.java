package com.coderefer.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class MsgProducer {
    public static void main(String[] args) {
        //    create connection properties as K=V in java.util.properties class obj
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        create Kafka Producer object
        KafkaProducer<String, String> p = new KafkaProducer<>(props);
        String msg = "Test Kafka messaging from Code";
        String topicName = "coderefer-topic";
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, msg);
        p.send(record); // send producer record
        p.flush(); // flush Kafka producer
        p.close(); // close Kafka Producer
    }
}
