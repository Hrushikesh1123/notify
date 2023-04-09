package com.notification.service.notificationcore.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${producer.bootstrap.servers}")
    private String bootstrapServers;

    @Value("${linger.ms}")
    private String lingerMsConfig;

    @Value("${acks}")
    private String ackConfig;


    @Bean(name = "kafkaProducerTemplate")
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.LINGER_MS_CONFIG,lingerMsConfig);
        props.put(ProducerConfig.ACKS_CONFIG,ackConfig);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
//        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,.class);

        DefaultKafkaProducerFactory<String,String> factory=new DefaultKafkaProducerFactory<>(props);

        return factory;
    }


}
