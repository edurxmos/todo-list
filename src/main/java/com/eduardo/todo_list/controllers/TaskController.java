package com.eduardo.todo_list.controllers;

import com.eduardo.todo_list.dtos.TaskRequestDTO;
import com.eduardo.todo_list.dtos.TaskResponseDTO;
import com.eduardo.todo_list.entities.Task;
import com.eduardo.todo_list.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDTO> list() {
        return taskService.list();
    }

    @PostMapping
    public List<TaskResponseDTO> create(@RequestBody TaskRequestDTO dto) {
        return taskService.create(dto);
    }

    @PutMapping("/{id}")
    public List<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        return taskService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public List<TaskResponseDTO> delete(@PathVariable Long id) {
        return taskService.delete(id);
    }

    @PutMapping("/done/{id}")
    public List<TaskResponseDTO> markAsDone(@PathVariable Long id) {
        return taskService.markAsDone(id);
    }

}
