package com.adepuu.exercises.session7;

import java.util.Date;

// Event class representing an event and its associated tickets
class Event {
    private String eventName;
    private Date eventDate;

    public Event(String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }
}

