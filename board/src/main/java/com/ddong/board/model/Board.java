package com.ddong.board.model;

import com.ddong.board.requestDto.BoardRequestDto;
import com.ddong.board.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Board(BoardRequestDto requestDto){
        if (requestDto.getTitle() == null || requestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("해당 제목이 유효하지 않습니다.");
        }

        if (requestDto.getContent() == null || requestDto.getContent().isEmpty()) {
            throw new IllegalArgumentException("해당 내용이 유효하지 않습니다.");
        }


        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

}
