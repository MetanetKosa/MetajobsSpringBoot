package com.example.metajobs.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long mem_no;
    @NotBlank(message="아이디는 필수 입력값입니다.")
    private String mem_id;
    @NotBlank(message="비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}", message = "비밀번호는 4~10자 영문 대/소문자, 숫자, 특수문자를 사용하세요.")
    private String mem_pw;
    private String mem_auth;
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String mem_name;
    //날짜형 입력받을시 문자형으로 들어오므로 패턴 지정해서 Date객체 만들기 400error
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mem_birth;
    private String mem_phone;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String mem_email;
    private String mem_address;
    private Date mem_joinDate;
    private Date mem_updateDate;
    private int mem_enabled;
}
