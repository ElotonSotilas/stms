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
    // Import foreign key from Account(account_id) to Task(reported_by)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_by", referencedColumnName = "account_id")
    public Account reported_by;

    // Import foreign key from Account(account_id) to Board(owner_id)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to", referencedColumnName = "account_id")
    public Account assigned_to;

    // Import foreign key from Account(account_id) to Board(owner_id)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    public Board board_id;

    // Constructors
    public Task() {}

    public Task(String title,
                String type, String status, String description,
                String priority, long story_points) {
        this.title = title;
        this.type = type;
        this.status = status;
        this.description = description;
        this.priority = priority;
        this.story_points = story_points;
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
