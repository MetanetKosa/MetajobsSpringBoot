package com.example.metajobs.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {


    private long rno;

    private long cno;
    private String reJob;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reDate;
    private String pnum;
    private String reContent;
    private String reResult;
    private Date reWdate;
    private long mno;
}
