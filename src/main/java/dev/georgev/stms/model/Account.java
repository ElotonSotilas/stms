package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    @ManyToMany
    @JoinTable(
            name = "board_member",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")
    )
    private Set<Board> boards;

    // Empty Account Constructor (Required for Hibernate to function)
    public Account () {}

    // Account Constructor using parameters
    public Account(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    // Define variables for each column in Account
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @NotNull
    @Id
    @Column(name = "account_id")
    private long account_id;

    @Column(name = "first_name")
    @NotEmpty(message = "Please, provide a first name.")
    @NotNull(message = "Please, provide a first name.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String first_name;

    @Column(name = "last_name")
    @NotEmpty(message = "Please, provide a last name.")
    @NotNull(message = "Please, provide a last name.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    private String last_name;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Please, provide an email.")
    @NotNull(message = "Please, provide an email.")
    @Size(max = 255, message = "Exceeding maximum size (255).")
    @Email(message = "Invalid email.")
    private String email;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and Setters

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public long getAccount_id() {
        return account_id;
    }
}
