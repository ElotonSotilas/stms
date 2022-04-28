package dev.georgev.stms.controller;

import dev.georgev.stms.model.Board;
import dev.georgev.stms.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
