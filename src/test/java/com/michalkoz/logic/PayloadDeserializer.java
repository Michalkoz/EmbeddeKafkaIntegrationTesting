package com.michalkoz.logic;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalkoz.logic.Payload;

    public class PayloadDeserializer implements Deserializer<Payload> {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Payload deserialize(String topic, byte[] data) {
            if (data == null) {
                return null;
            }

            try {
                return objectMapper.readValue(data, Payload.class);
            } catch (Exception e) {
                throw new RuntimeException("Failed to deserialize Payload", e);
            }
        }
    }
