package com.adepuu.exercises.session7;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketingSystem {
    /**
     * Write a Java Program using OOP about simple ticketing system for an event.
     * <p>
     * Feature Acceptance Criteria:
     * - Ticket Creation: The system should allow for the creation of a new ticket with a unique identifier, event name, and price.
     * - Ticket Booking: Users should be able to book a ticket by selecting an event and providing their details.
     * - Ticket Validation: The system should check if the ticket is still available for booking.
     * - Ticket Confirmation: After booking, the system should issue a confirmation ticket to the user.
     * <p>
     * OOP Concept-wise Acceptance Criteria:
     * - Classes and Objects: The system should define a Ticket class that serves as a blueprint for creating ticket objects. Each ticket object should represent a unique ticket for an event.
     * - Encapsulation: The Ticket class should encapsulate the ticket details (e.g., ticket ID, event name, price) by making them private and providing public getter and setter methods to access and modify these details.
     * - Static Keyword: The Ticket class should use a static field to keep track of the total number of tickets sold, demonstrating the use of static variables.
     * - Interface Implementation (Optional): Ticket class could implement an interface (e.g., Ticketable) that defines methods for printing ticket details, ensuring that all ticket types adhere to a common contract.
     * <p>
     * Start your project from the main method below ;) have fun!
     */
    private List<Ticket> availableTickets;
    private List<Ticket> bookedTickets;

    public TicketingSystem() {
        availableTickets = new ArrayList<>();
        bookedTickets = new ArrayList<>();
    }

    public void createTicket(String ticketId, Event event, double price) {
        Ticket ticket = new Ticket(ticketId, event, price);
        availableTickets.add(ticket);
    }

    public void bookTicket(Ticket ticket, User user) {
        if (availableTickets.contains(ticket)) {
            availableTickets.remove(ticket);
            bookedTickets.add(ticket);
            System.out.println("Ticket booked successfully for " + user.getName() + "!");
        } else {
            System.out.println("Ticket not available for booking.");
        }
    }

    public void printBookedTickets() {
        System.out.println("Booked Tickets:");
        for (Ticket ticket : bookedTickets) {
            ticket.printTicketDetails();
            System.out.println("--------------------");
        }
    }

    public void printAvailableTickets() {
        System.out.println("Available Tickets:");
        for (Ticket ticket : availableTickets) {
            ticket.printTicketDetails();
            System.out.println("--------------------");
        }
    }
    public static void main(String[] args) {
        // Creating users
        User user1 = new User("John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");

        // Creating events
        Date eventDate1 = new Date();
        Event event1 = new Event("Concert", eventDate1);

        Date eventDate2 = new Date();
        Event event2 = new Event("Theater Play", eventDate2);

        // Creating ticketing system
        TicketingSystem ticketingSystem = new TicketingSystem();

        // Creating tickets
        ticketingSystem.createTicket("T001", event1, 50.0);
        ticketingSystem.createTicket("T002", event2, 30.0);

        // Booking tickets
        Ticket ticket1 = new Ticket("T001", event1, 50.0);
        ticketingSystem.bookTicket(ticket1, user1);

        Ticket ticket2 = new Ticket("T002", event2, 30.0);
        ticketingSystem.bookTicket(ticket2, user2);

        // Printing booked and available tickets
        ticketingSystem.printBookedTickets();
        ticketingSystem.printAvailableTickets();

        // Printing total tickets sold
        System.out.println("Total Tickets Sold: " + Ticket.getTotalTicketsSold());
    }
}
