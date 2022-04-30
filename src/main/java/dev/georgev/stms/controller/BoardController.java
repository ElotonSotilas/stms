package dev.georgev.stms.controller;

import dev.georgev.stms.exception.ResourceNotFoundException;
import dev.georgev.stms.model.Account;
import dev.georgev.stms.model.Board;
import dev.georgev.stms.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // find board by ID
    @GetMapping("/board/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist: " + id));
        return ResponseEntity.ok(board);
    }

    @PostMapping("/board")
    public Board addBoard(@RequestBody Board b) {
        return boardRepository.save(b);
    }

    @DeleteMapping("/board")
    public boolean removeBoard(@RequestBody Board b) {
        TaskController tc = new TaskController();
        tc.removeAllTasks();
        return boardRepository.findAll().remove(b);
    }
}
