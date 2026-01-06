package com.eduardo.todo_list.controllers;

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
    public List<Task> list() {
        return taskService.list();
    }

    @PostMapping
    public List<Task> create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public List<Task> update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public List<Task> delete(@PathVariable Long id) {
        return taskService.delete(id);
    }

}
