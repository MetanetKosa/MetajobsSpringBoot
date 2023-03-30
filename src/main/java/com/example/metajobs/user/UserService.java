package com.example.metajobs.user;

import com.example.metajobs.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserVO> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public UserVO findUser(String mem_id) { return userMapper.findUser(mem_id); }

    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error: errors.getFieldErrors()) {
            String validKeyName = String.format("valie_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

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
