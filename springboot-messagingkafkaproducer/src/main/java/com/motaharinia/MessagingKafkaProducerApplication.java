package com.motaharinia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 13:24:37<br>
 * Description:<br>
 */
@SpringBootApplication(scanBasePackages = {"com.motaharinia"})
public class MessagingKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingKafkaProducerApplication.class, args);
    }

}
