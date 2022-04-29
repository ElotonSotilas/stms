package dev.georgev.stms.controller;

import dev.georgev.stms.model.BoardMember;
import dev.georgev.stms.repository.BoardMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BoardMemberController {
    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @GetMapping("/board_members")
    public List<BoardMember> getAllBoardMembers() {
        return boardMemberRepository.findAll();
    }

    @PostMapping("/board_members")
    public BoardMember addBoardMember(@RequestBody BoardMember bm) {
        return boardMemberRepository.save(bm);
    }

    @DeleteMapping("/board_members")
    public boolean removeBoardMember(@RequestBody BoardMember bm) {
        return boardMemberRepository.findAll().remove(bm);
    }
}
