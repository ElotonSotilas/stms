package dev.georgev.stms.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account {
    // Empty Account Constructor (Required for Hibernate to function)
    public Account () {}

    // Account Constructor using parameters
    public Account(long account_id, String first_name, String last_name, String email, Timestamp created_at, Timestamp updated_at) {
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
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
    @Min(value = 2, message = "Contents must be at least 2 characters long.")
    @Max(value = 255, message = "Contents exceed limit (255).")
    private String first_name;

    @Column(name = "last_name")
    @NotEmpty(message = "Please, provide a last name.")
    @Min(value = 2, message = "Contents must be at least 2 characters long.")
    @Max(value = 255, message = "Contents exceed limit (255).")
    private String last_name;

    @Column(name = "email")
    @NotEmpty(message = "Please, provide an email.")
    @Max(value = 255, message = "Contents exceed limit (255).")
    @Email(message = "Invalid email.")
    private String email;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    // Getters and Setters

    public long getAccount_id() {
        return this.account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

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
