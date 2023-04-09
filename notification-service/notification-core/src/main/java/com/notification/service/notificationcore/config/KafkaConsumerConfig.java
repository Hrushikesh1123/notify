package com.notification.service.notificationcore.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {


    @Value("${consumer.bootstrap.servers}")
    private String bootstrapAddress;

    @Value("${enable.auto.commit}")
    private boolean enableAutoCommit;

    @Value("${auto.commit.interval.ms}")
    private int autoCommitInterval;

    @Value("${session.timeout.ms}")
    private int sessionTimeOut;

    @Value("${heartbeat.interval.ms}")
    private int heartBeatInterval;

    @Value("${max.partition.fetch.bytes}")
    private int maxPartitionsFetchSize;

    @Value("${consumer.concurrency}")
    private int concurrency;

    @Value("${fetch.min.bytes}")
    private int fetMinBytes;

    @Value("${fetch.max.wait.ms}")
    private int fetchWaitMaxMs;

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String , Object> props=new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG,fetMinBytes);
        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG,fetchWaitMaxMs);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,enableAutoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,autoCommitInterval);
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG,maxPartitionsFetchSize);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,heartBeatInterval);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,sessionTimeOut);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);
        factory.setCommonErrorHandler(consumerAwareListenerErrorHandler());
        return factory;
    }

    @Bean
    public CommonErrorHandler consumerAwareListenerErrorHandler(){

//        return new CommonErrorHandler() {
//            @Override
//            public boolean seeksAfterHandling() {
//                return CommonErrorHandler.super.seeksAfterHandling();
//            }
//
//            @Override
//            public boolean handleOne(Exception thrownException, ConsumerRecord<?, ?> record, Consumer<?, ?> consumer, MessageListenerContainer container) {
//                return CommonErrorHandler.super.handleOne(thrownException, record, consumer, container);
//            }
//
//            @Override
//            public void handleRemaining(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
//                CommonErrorHandler.super.handleRemaining(thrownException, records, consumer, container);
//            }
//        };
        return new CommonErrorHandler() {
        };
    }



}
