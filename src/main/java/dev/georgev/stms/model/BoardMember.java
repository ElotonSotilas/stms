package dev.georgev.stms.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "board_member")
public class BoardMember {
    // Constructors
    public BoardMember() {}

    public BoardMember(long board_id, long account_id) {
        this.board_id = board_id;
        this.account_id = account_id;
    }

    // Columns
    @Id
    @Column(name = "board_id")
    @NotEmpty(message = "Please, provide a board ID.")
    private long board_id;

    @Column(name = "account_id")
    @NotEmpty(message = "Please, provide an account ID.")
    private long account_id;

    // Getters and Setters
    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }
}
