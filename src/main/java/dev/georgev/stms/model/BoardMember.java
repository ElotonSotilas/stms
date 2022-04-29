package dev.georgev.stms.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "board_member")
public class BoardMember {
    // Import foreign key from Account(account_id) to BoardMembers(account_id)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    public Account account;

    // Constructors
    public BoardMember() {}

    public BoardMember(long board_id) {
        this.board_id = board_id;
    }

    // Columns
    @Id
    @Column(name = "board_id")
    @NotEmpty(message = "Please, provide a board ID.")
    private long board_id;

    // Getters and Setters
    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }
}
