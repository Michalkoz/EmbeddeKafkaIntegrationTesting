package com.michalkoz.logic;

import com.michalkoz.logic.Payload;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayloadTest {

    @Test
    public void testPayload() {
        //given
        Payload myOwnPayload = new Payload(1, "5");

        //then
        assertEquals(1, myOwnPayload.getEventId());
        assertEquals("5", myOwnPayload.getEventName());
    }

}
