package com.example.metajobs.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
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
    public int delete(String mem_id);


}
