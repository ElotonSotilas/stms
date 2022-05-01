package dev.georgev.stms.repository;

import dev.georgev.stms.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {
    @Query("SELECT COUNT (project.project_id) FROM Task")
    long getProjectSize(Long id);
}
