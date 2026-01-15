package com.eduardo.todo_list.controllers;

import com.eduardo.todo_list.dtos.task.TaskRequestDTO;
import com.eduardo.todo_list.dtos.task.TaskResponseDTO;
import com.eduardo.todo_list.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponseDTO>> list(Pageable pageable) {
        return ResponseEntity.ok(taskService.list(pageable));
    }

    @PostMapping
    public ResponseEntity<Page<TaskResponseDTO>> create(@Valid @RequestBody TaskRequestDTO dto, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(dto, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Page<TaskResponseDTO>> update(@PathVariable Long id, @RequestBody TaskRequestDTO dto, Pageable pageable) {
        return ResponseEntity.ok(taskService.update(id, dto, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Page<TaskResponseDTO>> delete(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(taskService.delete(id, pageable));
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<Page<TaskResponseDTO>> markAsDone(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(taskService.markAsDone(id, pageable));
    }

}
