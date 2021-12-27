package com.ddong.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String userid;
    private String password;
    private String username;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
