package com.example.metajobs.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    private Long resume_no;
    private String resume_image;

    @Size(min = 2, max=100, message = "제목은 100자 이하로 입력해주세요")
    private String resume_title;
    private String resume_gender;
    private String resume_technology;
    private String resume_career;
    private Long mem_no;
    private String resume_cv;
    private Date regDate;
    private Date updateDate;


}
