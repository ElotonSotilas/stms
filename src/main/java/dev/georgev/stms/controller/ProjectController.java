package dev.georgev.stms.controller;

import dev.georgev.stms.model.Project;
import dev.georgev.stms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
