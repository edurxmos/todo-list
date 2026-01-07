package com.eduardo.todo_list.services;

import com.eduardo.todo_list.dtos.TaskRequestDTO;
import com.eduardo.todo_list.dtos.TaskResponseDTO;
import com.eduardo.todo_list.entities.Task;
import com.eduardo.todo_list.mappers.TaskMapper;
import com.eduardo.todo_list.repositories.TaskRepository;
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
    public List<TaskResponseDTO> list() {
        List<TaskResponseDTO> dto = taskRepository.findAll().stream().map(x -> taskMapper.toResponse(x)).toList();
        return dto;
    }

    public List<TaskResponseDTO> create(TaskRequestDTO task) {
        Task entity = taskMapper.toEntity(task);
        taskRepository.save(entity);
        return list();
    }

    public List<TaskResponseDTO> update(Long id, TaskRequestDTO dto) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        taskMapper.updateEntity(entity, dto);
        taskRepository.save(entity);
        return list();
    }

    public List<TaskResponseDTO> delete(Long id) {
        taskRepository.deleteById(id);
        return list();
    }

    @Transactional
    public List<TaskResponseDTO> markAsDone(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        task.markAsDone();
        return list();
    }

}
