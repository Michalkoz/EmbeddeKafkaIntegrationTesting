package com.michalkoz.logic;


import java.util.Objects;

public class Payload {
    private int eventId;
    private String eventName;

    // Default constructor
    public Payload() {}

    // Parameterized constructor
    public Payload(int eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return eventId == payload.eventId && Objects.equals(eventName, payload.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventName);
    }

    // Getters and setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // toString method
    @Override
    public String toString() {
        return "Payload{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
