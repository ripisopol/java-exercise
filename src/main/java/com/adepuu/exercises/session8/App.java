package com.adepuu.exercises.session8;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class App {
    /**
     * Manages user registration, login, and task management for the To-Do List application.
     * <p>
     * This function enables users to register, log in, and manage their tasks through the console.
     * It provides a clear and concise menu with options to add a task, view tasks, delete a task, or log out.
     * The system handles user input errors gracefully, providing clear feedback and prompting for correct input.
     * </p>
     * <br/>
     * <h3>User Registration and Login:</h3>
     * <ul>
     *     <li>Given a new user, when they input their desired login and password through the console, then the system should create a new account and confirm successful account creation.</li>
     *     <li>Given an existing user, when they input their login and password through the console, then the system should authenticate the user and grant access to the to-do list.</li>
     * </ul>
     *
     * <h3>Task Management:</h3>
     * <ul>
     *     <li>Given a logged-in user, when they input a new task through the console, then the system should add the task to their to-do list and confirm the task has been added.</li>
     *     <li>Given a logged-in user, when they view their to-do list through the console, then the system should display all tasks currently in their list.</li>
     *     <li>Given a logged-in user, when they input a task to delete through the console, then the system should remove the task from their to-do list and confirm the task has been deleted.</li>
     * </ul>
     *
     * <h3>Other:</h3>
     * <ul>
     *     <li>When a user accesses the application, the interface should display a clear and concise menu with options to add a task, view tasks, delete a task, or log out, all accessible through the console.</li>
     *     <li>The system should handle user input errors gracefully, providing clear feedback and prompting for correct input through the console.</li>
     * </ul>
     *
     * <h3>Notes:</h3>
     * <ul>
     *     <li>No need to encrypt user password</li>
     *     <li>Start the program menu inside main function below</li>
     *     <li>Split each functionalities into its own classes</li>
     *     <li>Please Use UUID if there's ID needed <a href="https://www.baeldung.com/java-uuid">Java UUID Reference</a></li>
     *     <li>Data does not need to be stored in a File. Instead, store it inside a Map or List and let the data gone when program finished</li>
     * </ul>
     */
    public static void main(String[] args) {
        /*
         Create menu functionalities
         Split classes
         Make methods
         Connect all the functionalities with the related menu ;)
         GL HF! ;)
        */
        UserManager userManager = new UserManager();
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            if (userManager.getLoggedInUser() == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter username: ");
                            String regUsername = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String regPassword = scanner.nextLine();
                            userManager.register(regUsername, regPassword);
                            break;
                        case 2:
                            System.out.print("Enter username: ");
                            String loginUsername = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String loginPassword = scanner.nextLine();
                            userManager.login(loginUsername, loginPassword);
                            break;
                        case 3:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume invalid input
                }
            } else {
                User loggedInUser = userManager.getLoggedInUser();
                System.out.println("Logged in as: " + loggedInUser.getUsername());
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Delete Task");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter task description: ");
                            String taskDescription = scanner.nextLine();
                            taskManager.addTask(loggedInUser.getUserId(), taskDescription);
                            break;
                        case 2:
                            taskManager.viewTasks(loggedInUser.getUserId());
                            break;
                        case 3:
                            System.out.print("Enter task ID to delete: ");
                            try {
                                UUID taskId = UUID.fromString(scanner.nextLine());
                                taskManager.deleteTask(taskId);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid task ID format.");
                            }
                            break;
                        case 4:
                            userManager.logout();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume invalid input
                }
            }
        }
        scanner.close();
    }
}
