package com.ddong.board.security;

import com.ddong.board.model.User;
import com.ddong.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {
    /*
    * spring security가 보내준 userId를 가지고 DB에서 찾아
    * 회원이 있는지 조회
    * userId를 찾을 수 없으면 error
    * 있다면 UserDetailsImpl에 반환
    */

    private final UserRepository userRepository;

//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(userid).orElseThrow(
//                () -> new UsernameNotFoundException("Can't find" + userid)
//        );
//
//        return new UserDetailsImpl(user);
//    }

}
