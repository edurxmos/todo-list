package com.eduardo.todo_list.dtos.task;

import java.time.Instant;

public record TaskResponseDTO(Long id, String title, String description, boolean done, Instant createdAt) {
}
