package com.manhica.api_todo_list.dtos.task;

import java.time.LocalDateTime;

public record TaskRequest(
        Long id,
        String title,
        String description,
        LocalDateTime due_date
) {
}
