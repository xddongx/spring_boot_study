package com.ddong.board.service;

import com.ddong.board.model.Board;
import com.ddong.board.repository.BoardRepository;
import com.ddong.board.dto.BoardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board updateBoards(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        String newTitle = requestDto.getTitle();
        String newContent = requestDto.getContent();

        if (newTitle == null || newTitle.isEmpty()) {
            throw new IllegalArgumentException("해당 제목이 유효하지 않습니다.");
        }

        if (newContent == null || newContent.isEmpty()) {
            throw new IllegalArgumentException("해당 내용이 유효하지 않습니다.");
        }

        board.updateBoard(requestDto);
        return board;
    }
}
