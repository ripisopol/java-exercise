package com.adepuu.exercises.session8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(UUID userId, String description) {
        Task newTask = new Task(userId, description);
        tasks.add(newTask);
        System.out.println("Task added successfully.");
    }

    public void viewTasks(UUID userId) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getUserId().equals(userId)) {
                userTasks.add(task);
            }
        }
        if (userTasks.isEmpty()) {
            System.out.println("No tasks available for this user.");
            return;
        }
        System.out.println("Tasks for user " + userId + ":");
        for (Task task : userTasks) {
            System.out.println("- Task ID: " + task.getTaskId() + ", Description: " + task.getDescription());
        }
    }

    public void deleteTask(UUID taskId) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskId().equals(taskId)) {
                tasks.remove(i);
                System.out.println("Task deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found.");
        }
    }
}
