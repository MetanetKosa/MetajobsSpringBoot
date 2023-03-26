package com.example.metajobs.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long mem_no;
    //@Size(min=4, message="4글자 이상 입력")
    private String mem_id;
    //@Size(min=4, message="4글자 이상 입력")
    private String mem_pw;
    private String mem_auth;
    private String mem_name;
    //날짜형 입력받을시 문자형으로 들어오므로 패턴 지정해서 Date객체 만들기 400error
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mem_birth;
    private String mem_phone;
    private String mem_email;
    private String mem_address;
    private Date mem_joinDate;
    private Date mem_updateDate;
    private int mem_enabled;
}
