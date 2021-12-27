package com.ddong.board.service;

import com.ddong.board.dto.UserRequestDto;
import com.ddong.board.model.User;
import com.ddong.board.model.UserRole;
import com.ddong.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public User registerUser(UserRequestDto requestDto) {
        String userid = requestDto.getUserid();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(userid);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        // 패스워드 인코딩(암호화)
        String password = requestDto.getPassword();

        String username = requestDto.getUsername();
        String email = requestDto.getEmail();

        // 사용자 ROLE 확인
        UserRole role = UserRole.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRole.ADMIN;
        }

        User user = new User(userid, password, username, email, role);
        userRepository.save(user);
        return user;
    }

}
