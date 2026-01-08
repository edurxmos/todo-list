package com.eduardo.todo_list.controllers;

import com.eduardo.todo_list.dtos.TaskRequestDTO;
import com.eduardo.todo_list.dtos.TaskResponseDTO;
import com.eduardo.todo_list.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Page<TaskResponseDTO> list(Pageable pageable) {
        return taskService.list(pageable);
    }

    @PostMapping
    public Page<TaskResponseDTO> create(@RequestBody TaskRequestDTO dto, Pageable pageable) {
        return taskService.create(dto, pageable);
    }

    @PutMapping("/{id}")
    public Page<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskRequestDTO dto, Pageable pageable) {
        return taskService.update(id, dto, pageable);
    }

    @DeleteMapping("/{id}")
    public Page<TaskResponseDTO> delete(@PathVariable Long id, Pageable pageable) {
        return taskService.delete(id, pageable);
    }

    @PutMapping("/done/{id}")
    public Page<TaskResponseDTO> markAsDone(@PathVariable Long id, Pageable pageable) {
        return taskService.markAsDone(id, pageable);
    }

}
