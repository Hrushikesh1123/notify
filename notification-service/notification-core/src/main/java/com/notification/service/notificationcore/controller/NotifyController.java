package com.notification.service.notificationcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyController {

//    private static final Logger log= LoggerFactory.getLogger(NotifyController.class);

//    @Autowired
//    @Qualifier("kafkaProducer1")
//    private KafkaProducer1 kafkaProducer;


    @GetMapping("/publish2")
    public void publish(){
        try {
            String data="test";
//            kafkaProducer.publish();
            System.out.println("published");
//            log.info("successfull");
        }catch (Exception e){
//            log.error("error while publishing ",e);
        }
    }


}
