package com.example.metajobs.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
    private Long postNo;
    private String postTitle;
    private String postJob;
    private String postCareer;
    private String postEmptype;
    private String postAdd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postSdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postFdate;
    private String postSal;
    private String postEdu;
    private String postAge;
    private String postHow;
    private String postUrl;
    private Long comCno;
    private Long memNo;
}
