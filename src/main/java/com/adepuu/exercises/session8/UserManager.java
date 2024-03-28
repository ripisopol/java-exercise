package com.adepuu.exercises.session8;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private User loggedInUser;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean register(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another one.");
                return false;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful. You can now log in.");
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully.");
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
