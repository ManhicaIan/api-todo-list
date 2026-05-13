package com.manhica.api_todo_list.dtos.task;

import com.manhica.api_todo_list.entities.Task;
import com.manhica.api_todo_list.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String title,
        String description,
        LocalDateTime due_date,
        LocalDateTime created_at,
        LocalDateTime completed_at,
        LocalDateTime updated_at,
        TaskStatus status
) {
    public TaskResponse(Task task) {
        this(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDue_date(),
                task.getCreated_at(),
                task.getCompleted_at(),
                task.getUpdated_at(),
                task.getTaskStatus()
        );
    }
}
