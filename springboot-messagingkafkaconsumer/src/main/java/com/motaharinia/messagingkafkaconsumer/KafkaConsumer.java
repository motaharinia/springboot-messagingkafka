package com.motaharinia.messagingkafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 14:04:26<br>
 * Description:<br>
 */
@Service
public class KafkaConsumer {
    private static final String KAFKA_TOPIC = "motahariniaTopic";
    private static final String KAFKA_GROUP_ID= "group_id";

    @KafkaListener(topics = KAFKA_TOPIC, groupId = KAFKA_GROUP_ID)
    public void consume(String message){
        System.out.println(String.format("$$ -> Consumed Message -> %s",message));
    }
}
