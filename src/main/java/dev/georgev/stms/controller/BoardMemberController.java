package dev.georgev.stms.controller;

import dev.georgev.stms.model.BoardMember;
import dev.georgev.stms.repository.BoardMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
