package com.example.metajobs.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    @GetMapping("/reviews")
//    public List<ReviewVO> getReviewList(Criteria cri){
//        return reviewService.getReviewList(cri);
//    }

    @GetMapping("/reviews")
    public List<ReviewVO> getReviewList(){
        return reviewService.getReviewList();
    }
}
