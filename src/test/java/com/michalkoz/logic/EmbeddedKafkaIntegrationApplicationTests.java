package com.michalkoz.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;


//@EmbeddedKafka(partitions = 1, topics = { "embedded-test-topic" })
//@ActiveProfiles("integration-test")

@SpringBootTest
//@ActiveProfiles("integration")
class EmbeddedKafkaIntegrationApplicationTests {

    @Autowired
    private Consumer consumer;

    @Autowired
    private KafkaEventFakeProducer kafkaEventFakeProducer ;

    @Test
    void contextLoads() throws InterruptedException, IOException {
        //given
//        Payload myOwnPayload = new Payload(1, "5");

        Payload myOwnPayload = readPayloadFromJsonFile("src/test/resources/payload.json");

        //when
        kafkaEventFakeProducer.send("embedded-test-topic", myOwnPayload);

        //then
        consumer.getLatch().await();
        Payload actualPayload = consumer.getPayload();

//        System.out.println("expectedPayload=" + myOwnPayload);
//        System.out.println("actualPayload=" + actualPayload);

        assertEquals(myOwnPayload, actualPayload);
    }

    private Payload readPayloadFromJsonFile(String filePath) throws IOException{
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, Payload.class);
    }
}

