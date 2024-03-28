package com.adepuu.exercises.session8;

import java.util.UUID;

public class Task {
    private UUID taskId;
    private UUID userId;
    private String description;

    public Task(UUID userId, String description) {
        this.taskId = UUID.randomUUID();
        this.userId = userId;
        this.description = description;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }
}
