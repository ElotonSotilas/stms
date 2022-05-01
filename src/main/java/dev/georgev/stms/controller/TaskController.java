package dev.georgev.stms.controller;

import dev.georgev.stms.exception.ResourceNotFoundException;
import dev.georgev.stms.model.Task;
import dev.georgev.stms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Update task
    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));
        t.setReported_by(task.getReported_by());
        t.setAssigned_to(task.getAssigned_to());
        t.setBoard_id(task.getBoard_id());
        t.setProject(task.getProject());
        t.setDescription(task.getDescription());
        t.setTitle(task.getTitle());
        t.setPriority(task.getPriority());
        t.setStatus(task.getStatus());
        t.setStory_points(task.getStory_points());
        t.setType(task.getType());

        Task updT = taskRepository.save(t);
        return ResponseEntity.ok(updT);
    }

    // Remove task
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));

        taskRepository.delete(task);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(res);
    }
}
