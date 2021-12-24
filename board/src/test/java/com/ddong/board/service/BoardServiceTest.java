package com.ddong.board.service;

import com.ddong.board.dto.BoardRequestDto;
import com.ddong.board.model.Board;
import com.ddong.board.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    BoardRepository boardRepository;

    @Test
    @DisplayName("updateBoard()에 의한 정상 변경 확인")
    void updateBoard_success() {
        // given
        Long boardId = 100L;
        String title = "변경 제목";
        String content = "변경 내용";

        BoardRequestDto requestDto = new BoardRequestDto(
                "변경 전 제목",
                "변경 전 내용"
        );
        Board board = new Board(requestDto);

        BoardRequestDto newRequestDto = new BoardRequestDto(
                title,
                content
        );

        BoardService boardService = new BoardService(boardRepository);
        when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));

        // when
        Board result = boardService.updateBoards(boardId, newRequestDto);

        // then
        assertEquals(title, result.getTitle());
    }

    @Nested
    @DisplayName("Fail")
    class Title {
        @Nested
        @DisplayName("Title")
        class Title_Fail {
            @Test
            @DisplayName("updateBoard()에 title 에러 발생")
            void updateBoard_fail1() {
                // given
                Long boardId = 100L;
                String title = null;
                String content = "변경 내용";

                BoardRequestDto requestDto = new BoardRequestDto(
                        "변경 전 제목",
                        "변경 전 내용"
                );
                Board board = new Board(requestDto);

                BoardRequestDto newRequestDto = new BoardRequestDto(
                        title,
                        content
                );

                BoardService boardService = new BoardService(boardRepository);
                when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));

                // when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    boardService.updateBoards(boardId, newRequestDto);
                });

                // then
                assertEquals("해당 제목이 유효하지 않습니다.", exception.getMessage());
            }

            @Test
            @DisplayName("updateBoard()에 title 에러 발생")
            void updateBoard_fail2() {
                // given
                Long boardId = 100L;
                String title = "";
                String content = "변경 내용";

                BoardRequestDto requestDto = new BoardRequestDto(
                        "변경 전 제목",
                        "변경 전 내용"
                );
                Board board = new Board(requestDto);

                BoardRequestDto newRequestDto = new BoardRequestDto(
                        title,
                        content
                );

                BoardService boardService = new BoardService(boardRepository);
                when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));

                // when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    boardService.updateBoards(boardId, newRequestDto);
                });

                // then
                assertEquals("해당 제목이 유효하지 않습니다.", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("Content")
        class Content_Fail {
            @Test
            @DisplayName("updateBoard()에 content 에러 발생")
            void updateBoard_fail1() {
                // given
                Long boardId = 100L;
                String title = "변경 내용";
                String content = null;

                BoardRequestDto requestDto = new BoardRequestDto(
                        "변경 전 제목",
                        "변경 전 내용"
                );
                Board board = new Board(requestDto);

                BoardRequestDto newRequestDto = new BoardRequestDto(
                        title,
                        content
                );

                BoardService boardService = new BoardService(boardRepository);
                when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));

                // when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    boardService.updateBoards(boardId, newRequestDto);
                });

                // then
                assertEquals("해당 내용이 유효하지 않습니다.", exception.getMessage());
            }

            @Test
            @DisplayName("updateBoard()에 content 에러 발생")
            void updateBoard_fail2() {
                // given
                Long boardId = 100L;
                String title = "변경 내용";
                String content = "";

                BoardRequestDto requestDto = new BoardRequestDto(
                        "변경 전 제목",
                        "변경 전 내용"
                );
                Board board = new Board(requestDto);

                BoardRequestDto newRequestDto = new BoardRequestDto(
                        title,
                        content
                );

                BoardService boardService = new BoardService(boardRepository);
                when(boardRepository.findById(boardId)).thenReturn(Optional.of(board));

                // when
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    boardService.updateBoards(boardId, newRequestDto);
                });

                // then
                assertEquals("해당 내용이 유효하지 않습니다.", exception.getMessage());
            }
        }
    }
}