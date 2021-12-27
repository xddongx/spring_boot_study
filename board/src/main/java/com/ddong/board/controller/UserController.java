package com.ddong.board.controller;

import com.ddong.board.dto.UserRequestDto;
import com.ddong.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    // 회원 로그인 페이지
//    @GetMapping("/user/login")
//    public String login() {
//        return "login";
//    }
//
//    // 회원 가인 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }
//
//    @PostMapping("/user/signup")
//    public String registerUser(UserRequestDto requestDto) {
//        userService.registerUser(requestDto);
//        return requestDto.toString();
//    }
//
//    // 로그인 에러 페이지
//    @GetMapping("/user/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }
//
//    @GetMapping("/user/forbidden")
//    public String forbidden() {
//        return "forbidden";
//    }
}
