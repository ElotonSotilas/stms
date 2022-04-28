package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class Task {
    // Constructors
    public Task() {}

    public Task(long task_id, String title,
                long project_id, long board_id,
                String type, String status, String description,
                long reported_by, long assigned_to,
                String priority, long story_points,
                Timestamp created_at, Timestamp updated_at) {
        this.task_id = task_id;
        this.title = title;
        this.project_id = project_id;
        this.board_id = board_id;
        this.type = type;
        this.status = status;
        this.description = description;
        this.reported_by = reported_by;
        this.assigned_to = assigned_to;
        this.priority = priority;
        this.story_points = story_points;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long task_id;

    @Column(name = "title")
    @NotEmpty(message = "Please, provide a task title.")
    @Max(value = 255, message = "Contents exceed limit (255).")
    private String title;

    @Column(name = "project_id")
    @NotEmpty(message = "Please, provide a project ID.")
    private long project_id;

    @Column(name = "board_id")
    @NotEmpty(message = "Please, provide a board ID.")
    private long board_id;

    @Column(name = "type")
    @Max(value = 50, message = "Contents exceed limit (50).")
    private String type;

    @Column(name = "status")
    @Nullable
    @Max(value = 50, message = "Contents exceed limit (50).")
    @Value("New")
    private String status;

    @Column(name = "description")
    @Nullable
    private String description;

    @Column(name = "reported_by")
    @NotEmpty(message = "Please, enter a valid account ID.")
    private long reported_by;

    @Column(name = "assigned_to")
    @Nullable
    private long assigned_to;

    @Column(name = "priority")
    @Nullable
    @Value("Low")
    private String priority;

    @Column(name = "story_points")
    @Nullable
    private long story_points;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and Setters
    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReported_by() {
        return reported_by;
    }

    public void setReported_by(long reported_by) {
        this.reported_by = reported_by;
    }

    public long getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(long assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getStory_points() {
        return story_points;
    }

    public void setStory_points(long story_points) {
        this.story_points = story_points;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
