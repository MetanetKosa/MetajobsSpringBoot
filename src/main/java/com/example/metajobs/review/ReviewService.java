package com.example.metajobs.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewVO> getReviewList(){
        return reviewMapper.getList();
    };

//    public List<ReviewVO> getReviewList(Criteria cri){
//        return reviewMapper.getList();
//    };

    public boolean insertReview(ReviewVO review){
        return reviewMapper.reviewInsert(review);
    };

    public ReviewVO getReview(long rno){
        return reviewMapper.get(rno);
    };

    public int getTotal(Criteria cri){
        return reviewMapper.getTotalCount(cri);
    };

    public boolean deleteReview(long rno){
        return reviewMapper.reviewDelete(rno) == 1;
    };

    public boolean updateReview(ReviewVO review){
        return reviewMapper.reviewUpdate(review) == 1;
    };

}
