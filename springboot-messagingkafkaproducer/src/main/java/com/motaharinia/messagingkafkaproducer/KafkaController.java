package com.motaharinia.messagingkafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 13:24:37<br>
 * Description:<br>
 */

@RestController
public class KafkaController {

    KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer=kafkaProducer;
    }

    @Value("${spring.application.name}")
    private String springApplicationName;

    @RequestMapping("/")
    public String getUrl() {
        return springApplicationName;
    }

    //http://localhost:8080/kafka/producer?message=test
    @GetMapping(value = "/kafka/producer")
    public String kafkaProducer(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return "Message sent to the Kafka testTopic Successfully";
    }

}
