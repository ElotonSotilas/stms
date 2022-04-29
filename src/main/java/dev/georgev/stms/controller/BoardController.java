package dev.georgev.stms.controller;

import dev.georgev.stms.model.Board;
import dev.georgev.stms.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
