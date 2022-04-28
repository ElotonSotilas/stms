package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Table(name = "project", uniqueConstraints = @UniqueConstraint(columnNames = "project_key"))
public class Project {
    // Constructors
    public Project() {}

    public Project(long project_id, String project_key, String title, long owner_id, Timestamp created_at, Timestamp updated_at) {
        this.project_id = project_id;
        this.project_key = project_key;
        this.title = title;
        this.owner_id = owner_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long project_id;

    @Column(name = "project_key")
    @NotEmpty(message = "Please, provide a project key.")
    @Max(value = 50, message = "Contents exceed limit (50).")
    private String project_key;

    @Column(name = "title")
    @NotEmpty(message = "Please, provide a project title.")
    @Max(255)
    private String title;

    @Column(name = "owner_id")
    @NotEmpty(message = "Please, provide an owner ID.")
    private long owner_id;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and setters

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getKey() {
        return project_key;
    }

    public void setKey(String key) {
        this.project_key = key;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
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