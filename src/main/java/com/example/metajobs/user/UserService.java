package com.example.metajobs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserVO findUser(String mem_id) { return userMapper.findUser(mem_id); }

    //회원가입
    public void insertMember(UserVO user) { userMapper.insertMember(user);}

    //로그인
    public UserVO loginMember(UserVO user) { return userMapper.loginMember(user); }

    //로그인 pw 조회
    public String readPw(String mem_id) { return userMapper.readPw(mem_id); }

    //회원정보 변경
    public void updateMember(UserVO user) { userMapper.updateMember(user); }

    //회원 탈퇴
    public void delete(String mem_id) { userMapper.delete(mem_id); }
}
