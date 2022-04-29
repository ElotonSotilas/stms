package dev.georgev.stms.controller;

import dev.georgev.stms.model.Task;
import dev.georgev.stms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task t) {
        return taskRepository.save(t);
    }

    @DeleteMapping("/task")
    public boolean removeTask(@RequestBody Task t) {
        return taskRepository.findAll().remove(t);
    }

    // Auxiliary function
    public void removeAllTasks() {
        this.getAllTasks().removeAll(this.getAllTasks());
    }
}
