package com.ddong.board.security;

import com.ddong.board.model.User;
import com.ddong.board.model.UserRole;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl {

    private static final String ROLE_PREFIX = "ROLE_";
    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

//    public User getUser() {
//        return user;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUserid();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        UserRole userRole = user.getRole();             // DB에서 조회해온 User 객체, 객체의 역할을 가져온다.
//
//        // Spring security가 ROLE_USER, ROLE_ADMIN을 인식할 수 있다.
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + userRole.toString());
//        // List인 이유는 여러개의 권한을 가질 수 있음
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(authority);
//        return authorities;
//    }
}
