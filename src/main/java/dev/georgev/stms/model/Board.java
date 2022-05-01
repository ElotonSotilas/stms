package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "board")
public class Board {
    @ManyToMany(mappedBy = "boards")
    public Set<Account> members;

    // Create foreign key
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "account_id")
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
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String name;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
