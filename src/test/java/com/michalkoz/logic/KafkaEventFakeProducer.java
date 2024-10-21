package com.michalkoz.logic;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.michalkoz.logic.Payload;

@Component
public class KafkaEventFakeProducer {

    private final KafkaTemplate<String, Payload> kafkaTemplate;

    public KafkaEventFakeProducer(KafkaTemplate<String, Payload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Payload payload) {
        kafkaTemplate.send(topic, payload);
    }

    KafkaTemplate<String, Payload> getKafkaTemplate() {
        return kafkaTemplate;
    }
}
