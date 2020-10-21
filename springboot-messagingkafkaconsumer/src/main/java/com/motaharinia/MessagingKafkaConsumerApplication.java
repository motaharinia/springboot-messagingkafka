package com.motaharinia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 14:04:26<br>
 * Description:<br>
 */
@SpringBootApplication(scanBasePackages = {"com.motaharinia"})
public class MessagingKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingKafkaConsumerApplication.class, args);
    }

}
