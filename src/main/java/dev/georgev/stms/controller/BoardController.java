package dev.georgev.stms.controller;

import dev.georgev.stms.exception.ResourceNotFoundException;
import dev.georgev.stms.model.Board;
import dev.georgev.stms.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Update board
    @PutMapping("/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board board) {
        Board b = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board does not exist: " + id));
        b.setName(board.getName());

        Board updBoard = boardRepository.save(b);
        return ResponseEntity.ok(updBoard);
    }

    // Remove board
    @DeleteMapping("/board/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Long id) {
        Board b = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board does not exist: " + id));

        boardRepository.delete(b);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(res);
    }
}
