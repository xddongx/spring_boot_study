package com.ddong.board.util;

import com.ddong.board.dto.BoardRequestDto;
import com.ddong.board.model.Board;

public class BoardValidator {
    public static Boolean boardValidator(BoardRequestDto requestDto) {
        try {
            if (requestDto.getTitle() == null || requestDto.getTitle().isEmpty()) {
                throw new IllegalArgumentException("해당 제목이 유효하지 않습니다.");
            }

            if (requestDto.getContent() == null || requestDto.getContent().isEmpty()) {
                throw new IllegalArgumentException("해당 내용이 유효하지 않습니다.");
            }
            return true;
        } catch (Exception exception){
            return false;
        }

    }
}
