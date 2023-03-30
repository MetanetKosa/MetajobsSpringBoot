package com.example.metajobs.review;

import com.example.metajobs.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/reviews")
    public ResponseEntity insertReview(@RequestBody ReviewVO review){
        reviewService.insertReview(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(review.getRno())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/reviews/{rno}")
    public void deleteUser(@PathVariable int rno){
        ReviewVO review = reviewService.getReview(rno);

//        if(review == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
        reviewService.deleteReview(rno);
    }
}
