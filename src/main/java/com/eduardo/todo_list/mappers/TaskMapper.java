package com.eduardo.todo_list.mappers;

import com.eduardo.todo_list.dtos.TaskRequestDTO;
import com.eduardo.todo_list.dtos.TaskResponseDTO;
import com.eduardo.todo_list.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDTO dto) {
        return new Task(dto.title(), dto.description());
    }

    public TaskResponseDTO toResponse(Task entity) {
        return new TaskResponseDTO(entity.getId(), entity.getTitle(), entity.getDescription(), entity.isDone(), entity.getCreatedAt());
    }

}
