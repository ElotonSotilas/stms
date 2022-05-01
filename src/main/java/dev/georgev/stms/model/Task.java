package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {
    // Create foreign key
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_by", referencedColumnName = "account_id")
    public Account reported_by;

    // Create foreign key
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to", referencedColumnName = "account_id")
    @Nullable
    public Account assigned_to;

    // Create foreign key
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    public Board board_id;

    // Create foreign key
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    public Project project;

    // Constructors
    public Task() {}

    public Task(String title,
                String type, String status, String description,
                String priority, long story_points,
                Account reported_by, Account assigned_to,
                Board board_id, Project project) {
        this.title = title;
        this.type = type;
        this.status = status;
        this.description = description;
        this.priority = priority;
        this.story_points = story_points;
        this.reported_by = reported_by;
        this.assigned_to = assigned_to;
        this.board_id = board_id;
        this.project = project;
    }

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long task_id;

    @Column(name = "title")
    @NotEmpty(message = "Please, provide a task title.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String title;

    @Column(name = "type",
            columnDefinition = "CHECK (type in ('Story', 'Bug', 'Epic', 'New Feature', 'Technical Debt'))")
    @Size(max = 50)
    private String type;

    @Column(name = "status", nullable = false,
            columnDefinition = "CHECK (status in ('New', 'In Development', 'In QA', 'Done'))")
    @Size(max = 50)
    @Value("New")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "priority", nullable = false,
            columnDefinition = "CHECK (priority in ('Low', 'Medium', 'High'))")
    @Value("Low")
    @Size(max = 50)
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (Objects.equals(type, "Story") ||
        Objects.equals(type, "Bug") ||
        Objects.equals(type, "Epic") ||
        Objects.equals(type, "New Feature") ||
        Objects.equals(type, "Technical Debt")) {
            this.type = type;
        }
    } // Possible values

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (Objects.equals(status,"New") ||
        Objects.equals(status, "In Development") ||
        Objects.equals(status, "In QA") ||
        Objects.equals(status, "Done")) {
            this.status = status;
        }
    } // validation of entries

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
        if (Objects.equals(priority, "Low") ||
            Objects.equals(priority, "Medium") ||
            Objects.equals(priority, "High")) {
            this.priority = priority;
        }
    } // Must be one of these values to set.

    public long getStory_points() {
        return story_points;
    }

    public void setStory_points(long story_points) {
        this.story_points = story_points;
    }

    public Account getReported_by() {
        return reported_by;
    }

    public void setReported_by(Account reported_by) {
        this.reported_by = reported_by;
    }

    public Account getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(Account assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Board getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Board board_id) {
        this.board_id = board_id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}