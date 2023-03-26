package com.example.metajobs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserVO> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public UserVO findUser(String mem_id) { return userMapper.findUser(mem_id); }

    //회원가입
    public void insertMember(UserVO user) { userMapper.insertMember(user);}

    //로그인
    public UserVO loginMember(UserVO user) { return userMapper.loginMember(user); }

    //로그인 pw 조회
    public String readPw(String mem_id) { return userMapper.readPw(mem_id); }

    //회원정보 변경
    public void updateMember(String mem_id, UserVO updateUser) {
        UserVO user = userMapper.findUser(mem_id);

        if (user != null) {
            user.setMem_id(updateUser.getMem_id());
            user.setMem_birth(updateUser.getMem_birth());
            user.setMem_phone(updateUser.getMem_phone());
            user.setMem_address(updateUser.getMem_address());
            user.setMem_email(updateUser.getMem_email());

            userMapper.updateMember(user);
        } else {
            throw new IllegalStateException("회원정보가 존재하지 않습니다.");
        }
    }

    //회원 탈퇴
    public void deleteMember(String mem_id) {
        if (userMapper.findUser(mem_id) != null) {
            userMapper.deleteMember(mem_id);
        } else {
            throw new IllegalStateException("회원정보가 존재하지 않습니다.");
        }
    }
}
