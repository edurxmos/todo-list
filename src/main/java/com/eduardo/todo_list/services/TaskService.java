package com.eduardo.todo_list.services;

import com.eduardo.todo_list.entities.Task;
import com.eduardo.todo_list.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> list() {
        return taskRepository.findAll();
    }

    public List<Task> create(Task task) {
        taskRepository.save(task);
        return list();
    }

    public List<Task> update(Task task) {
        taskRepository.save(task);
        return list();
    }

    public List<Task> delete(Long id) {
        taskRepository.deleteById(id);
        return list();
    }

    @Transactional
    public List<Task> markAsDone(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
        task.markAsDone();
        return list();
    }

}
