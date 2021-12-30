package com.ddong.board.controller;

import com.ddong.board.model.Board;
import com.ddong.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class HomeController {
    private final BoardRepository boardRepository;

    @Autowired
    public HomeController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Test Title");
        return "views/index";
    }

    @GetMapping("/boards")
    public String boards() {
        return "views/board/list";
    }

    @GetMapping("/boards/details/{id}")
    public String boardDetail() {
        return "views/board/detail";
    }

    @GetMapping("/boards/creates")
    public String boardCreate() {
        return "views/board/create";
    }
}
