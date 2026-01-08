package com.eduardo.todo_list.services;

import com.eduardo.todo_list.dtos.TaskRequestDTO;
import com.eduardo.todo_list.dtos.TaskResponseDTO;
import com.eduardo.todo_list.entities.Task;
import com.eduardo.todo_list.mappers.TaskMapper;
import com.eduardo.todo_list.repositories.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional(readOnly = true)
    public Page<TaskResponseDTO> list(Pageable pageable) {
        Page<TaskResponseDTO> dto = taskRepository.findAll(pageable).map(x -> taskMapper.toResponse(x));
        return dto;
    }

    public Page<TaskResponseDTO> create(TaskRequestDTO task, Pageable pageable) {
        Task entity = taskMapper.toEntity(task);
        taskRepository.save(entity);
        return list(pageable);
    }

    public Page<TaskResponseDTO> update(Long id, TaskRequestDTO dto, Pageable pageable) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        taskMapper.updateEntity(entity, dto);
        taskRepository.save(entity);
        return list(pageable);
    }

    public Page<TaskResponseDTO> delete(Long id, Pageable pageable) {
        taskRepository.deleteById(id);
        return list(pageable);
    }

    @Transactional
    public Page<TaskResponseDTO> markAsDone(Long id, Pageable pageable) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        task.markAsDone();
        return list(pageable);
    }

}
