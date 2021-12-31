package com.ddong.board.model;

import com.ddong.board.dto.BoardRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Nested
    @DisplayName("게시판 생성")
    class CreateBoard {
        private String title;
        private String content;

        // 각 test에 값을 입력해 줌
        @BeforeEach
        void setup() {
            title = "오늘은 뭘 먹어야 하나?";
            content = "역시 고기 구워 먹어야지!!";
        }

        @Test
        @DisplayName("정상 케이스")
        void createBoard_success() {
            // given
            BoardRequestDto requestDto = new BoardRequestDto(title, content);

            // when
            Board board = new Board(requestDto);

            // then
            assertNull(board.getId());
            assertEquals(title, board.getTitle());
            assertEquals(content, board.getContent());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCase {

            @Nested
            @DisplayName("제목")
            class Title {

                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    title = null;
                    BoardRequestDto requestDto = new BoardRequestDto(title, content);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Board(requestDto);
                    });

                    // then
                    assertEquals("해당 제목이 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    title = "";
                    BoardRequestDto requestDto = new BoardRequestDto(title, content);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Board(requestDto);
                    });

                    // then
                    assertEquals("해당 제목이 유효하지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("내용")
            class Content {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    content = null;
                    BoardRequestDto requestDto = new BoardRequestDto(title, content);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Board(requestDto);
                    });

                    // then
                    assertEquals("해당 내용이 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("빈 내용")
                void fail2() {
                    // given
                    content = "";
                    BoardRequestDto requestDto = new BoardRequestDto(title, content);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Board(requestDto);
                    });

                    // then
                    assertEquals("해당 내용이 유효하지 않습니다.", exception.getMessage());
                }
            }
        }
    }

}