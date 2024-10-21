package com.michalkoz.logic;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import java.util.concurrent.CountDownLatch;

@Component
public class Consumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private Payload payload;

    @KafkaListener(topics = "embedded-test-topic", groupId = "test")
    public void consume(Payload payload) {
        this.payload = payload;
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public Payload getPayload() {
        return payload;
    }
}
