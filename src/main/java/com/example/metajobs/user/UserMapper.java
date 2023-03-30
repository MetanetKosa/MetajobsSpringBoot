package com.example.metajobs.user;

import com.example.metajobs.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<UserVO> findAllUsers();

    public UserVO findUser(String mem_id);

    //회원가입
    public void insertMember(UserVO user);

    //로그인
    public UserVO loginMember(UserVO user);

    //로그인 pw 조회
    public String readPw(String mem_id);

    //회원정보 변경
    public void updateMember(UserVO user);

    //회원 탈퇴
    public void deleteMember(String mem_id);


}
