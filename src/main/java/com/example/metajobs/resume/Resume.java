package com.example.metajobs.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    private Long resume_no;
    private String resume_image;
    private String resume_title;
    private String resume_gender;
    private String resume_technology;
    private String resume_career;
    private Long mem_no;
    private String resume_cv;
    private Date regDate;
    private Date updateDate;


}
