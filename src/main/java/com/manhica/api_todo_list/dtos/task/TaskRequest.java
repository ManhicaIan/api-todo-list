package com.manhica.api_todo_list.dtos.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TaskRequest(
        Long id,

        @NotBlank(message = "Title is required")
        @Size(min = 3, message = "Title must have at least 3 characters")
        String title,

        @NotBlank(message = "Title is required")
        @Size(min = 3, message = "Description must have at least 3 characters")
        String description,

        @Future(message = "Due date must be in future")
        LocalDateTime due_date
) {
}
