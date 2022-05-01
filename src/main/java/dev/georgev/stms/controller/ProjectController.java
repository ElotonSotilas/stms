package dev.georgev.stms.controller;

import dev.georgev.stms.exception.ResourceNotFoundException;
import dev.georgev.stms.model.Project;
import dev.georgev.stms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/project")
    public Project addProject(@RequestBody Project p) {
        return projectRepository.save(p);
    }

    // Update project
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project p = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));
        p.setKey(project.getKey());
        p.setTitle(project.getTitle());
        p.setOwner_id(project.getOwner_id());

        Project updProj = projectRepository.save(p);
        return ResponseEntity.ok(updProj);
    }

    // Remove project
    @DeleteMapping("/project/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));

        projectRepository.delete(project);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(res);
    }
}
