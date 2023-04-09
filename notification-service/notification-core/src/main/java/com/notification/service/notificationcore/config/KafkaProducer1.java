package com.notification.service.notificationcore.config;


import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@EnableKafka
@Service(value = "kafkaProducer1")
public class KafkaProducer1 {


    private static final Logger log= LoggerFactory.getLogger(KafkaProducer1.class);


    @Autowired
    @Qualifier("kafkaProducerTemplate")
    private KafkaTemplate<String,String> kafkaTemplate;

    @SneakyThrows
    public void publishMessage(String topic,String unifiedData){

        try{
            log.info("payload {} received for push in kafka topic : {}",unifiedData,topic);
            kafkaTemplate.send(topic,unifiedData).get(2L, TimeUnit.SECONDS);
            log.info("successfully pushed message in topic");
        }catch (Exception exe){
            log.error("Error while publicshing data " , exe);

            throw exe;
        }
    }

    @GetMapping("/publish")
    public void publish(){
        try {
            String data="test";
            kafkaTemplate.send("TOPIC_INITIAL_1",data);
            System.out.println("published");
            log.info("successfull");
        }catch (Exception e){
            log.error("error while publishing ",e);
        }
    }




}
