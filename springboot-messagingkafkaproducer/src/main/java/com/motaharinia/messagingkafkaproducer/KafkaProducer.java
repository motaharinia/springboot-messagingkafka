package com.motaharinia.messagingkafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-08-24<br>
 * Time: 13:24:37<br>
 * Description:<br>
 *     این کلاس ارسال کننده پیام از طریق آپاچی کافکا میباشد
 */
@Service
public class KafkaProducer {

    /**
     * قالب کافکا برای ارسال پیامها
     */
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * عنوان کافکا که در گیرنده نیز میتوان با این عنوان کافکا پیامها را دریافت نمود
     */
    private static final String KAFKA_TOPIC = "motahariniaTopic";

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate=kafkaTemplate;
    }


    /**
     * این متد یم پیام را از ورودی دریافت میکند و به تاپیک کافکا تنظیم شده ارسال میکند
     * @param message
     */
    public void send(String message) {
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(KAFKA_TOPIC, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("KafkaProducer.send: Unable to send message=["+message+"] due to : "+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("KafkaProducer.send: Sent message=["+message+"] with offset=["+result.getRecordMetadata().offset()+"]");
            }
        });
    }
}
