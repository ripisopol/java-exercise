package com.adepuu.exercises.session10;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagement {
    /**
     * Acceptance Criteria:
     * - Each material should have an availability count, and the program should check if the material is still available for borrowing.
     * - The program should demonstrate polymorphism by allowing operations (borrow, return) to be performed on any type of library material through a single method.
     * - The program should include methods to borrow and return materials.
     * - The program should keep track of the available and borrowed materials.
     * - The program should print out the status of materials (available, borrowed) and the actions performed (borrow, return).
     *
     * Notes:
     * - The program doesn't require a menu system; focus should be on Object-Oriented Programming (OOP) and inheritance implementation.
     * - Make sure to implement Inheritance and Polymorphism properly
     */
    private Map<Integer, LibraryMaterial> libraryMaterials;

    public LibraryManagement() {
        libraryMaterials = new HashMap<>();
    }

    public void addMaterial(int id, LibraryMaterial material) {
        libraryMaterials.put(id, material);
    }

    public void borrowMaterial(int id) {
        if (libraryMaterials.containsKey(id)) {
            LibraryMaterial material = libraryMaterials.get(id);
            material.borrow();
        } else {
            System.out.println("Material not found.");
        }
    }

    public void returnMaterial(int id) {
        if (libraryMaterials.containsKey(id)) {
            LibraryMaterial material = libraryMaterials.get(id);
            material.returnMaterial();
        } else {
            System.out.println("Material not found.");
        }
    }

    public void displayMaterialInfo(int id) {
        if (libraryMaterials.containsKey(id)) {
            LibraryMaterial material = libraryMaterials.get(id);
            material.displayInfo();
        } else {
            System.out.println("Material not found.");
        }
    }
    public static void main(String[] args) {
        LibraryManagement librarySystem = new LibraryManagement();

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 5);
        Magazine magazine = new Magazine("National Geographic", 123, 3);

        librarySystem.addMaterial(1, book);
        librarySystem.addMaterial(2, magazine);

        librarySystem.borrowMaterial(1);
        librarySystem.borrowMaterial(1);
        librarySystem.borrowMaterial(2);

        librarySystem.returnMaterial(1);

        librarySystem.displayMaterialInfo(1);
        librarySystem.displayMaterialInfo(2);
    }
}
abstract class LibraryMaterial {
    private int availabilityCount;

    public LibraryMaterial(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public int getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public void borrow() {
        if (availabilityCount > 0) {
            availabilityCount--;
            System.out.println("Material borrowed successfully.");
        } else {
            System.out.println("Material not available for borrowing.");
        }
    }

    public void returnMaterial() {
        availabilityCount++;
        System.out.println("Material returned successfully.");
    }

    public abstract void displayInfo();
}

class Book extends LibraryMaterial {
    private String title;
    private String author;

    public Book(String title, String author, int availabilityCount) {
        super(availabilityCount);
        this.title = title;
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + getAvailabilityCount());
    }
}

class Magazine extends LibraryMaterial {
    private String title;
    private int issueNumber;

    public Magazine(String title, int issueNumber, int availabilityCount) {
        super(availabilityCount);
        this.title = title;
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine Title: " + title);
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Availability: " + getAvailabilityCount());
    }
}