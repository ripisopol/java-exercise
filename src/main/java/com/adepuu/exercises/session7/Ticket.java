package com.adepuu.exercises.session7;

import java.util.UUID;

public class Ticket implements Ticketable{
    private String  ticketId;
    private Event event;
    private double price;
    private static int totalTicketsSold = 0;

    public Ticket(String  ticketId, Event event, double price) {
        this.ticketId = ticketId;
        this.event = event;
        this.price = price;
        totalTicketsSold++;
    }

    public String  getTicketId() {
        return ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalTicketsSold() {
        return totalTicketsSold;
    }

    public void printTicketDetails() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("Event Date: " + event.getEventDate());
        System.out.println("Price: $" + price);
    }
}
