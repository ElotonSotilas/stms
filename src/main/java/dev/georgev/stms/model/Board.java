package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "board")
public class Board {
    @ManyToMany(mappedBy = "boards")
    public Set<Account> members;

    // Create foreign key
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    public Account owner;

    // Constructors
    public Board() {}

    public Board(String name) {
        this.name = name;
    }

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "board_id")
    private long board_id;

    @Column(name = "name", unique = true)
    @NotEmpty(message = "Please, provide a name.")
    @Min(value = 2, message = "Contents must be at least 2 characters long.")
    @Max(value = 255, message = "Contents exceed limit (255).")
    private String name;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and setters
    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
