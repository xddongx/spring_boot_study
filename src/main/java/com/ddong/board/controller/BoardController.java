package com.ddong.board.controller;

import com.ddong.board.dto.BoardRequestDto;
import com.ddong.board.model.Board;
import com.ddong.board.repository.BoardRepository;
import com.ddong.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    // GET
    @GetMapping("/api/boards")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @GetMapping("/api/boards/{id}")
    public Board getBoards(@PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 Id가 존재하지 않습니다.")
        );
        return board;
    }

    // POST
    @PostMapping("/api/boards")
    public Board createBoards(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    // PUT
    @PutMapping("/api/boards/{id}")
    public Long updateBoards(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Board board = boardService.updateBoards(id, requestDto);
        return board.getId();
    }
}
