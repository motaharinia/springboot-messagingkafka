package com.motaharinia.messagingkafkaconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 14:04:26<br>
 * Description:<br>
 */
@RestController
public class KafkaController {


    @Value("${spring.application.name}")
    private String springApplicationName;

    @RequestMapping("/")
    public String getUrl() {
        return springApplicationName;
    }

}
