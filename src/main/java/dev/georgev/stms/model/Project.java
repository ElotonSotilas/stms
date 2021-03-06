package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "project", uniqueConstraints = @UniqueConstraint(columnNames = "project_key"))
public class Project {
    public Account getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Account owner_id) {
        this.owner_id = owner_id;
    }

    // Create foreign key
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "account_id")
    public Account owner_id;

    // Constructors
    public Project() {}

    public Project(long project_id, String project_key, String title, Account owner_id) {
        this.owner_id = owner_id;
        this.project_id = project_id;
        this.project_key = project_key;
        this.title = title;
    }

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long project_id;

    @Column(name = "project_key")
    @NotEmpty(message = "Please, provide a project key.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String project_key;

    @Column(name = "title")
    @NotEmpty(message = "Please, provide a project title.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String title;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and setters

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
}
