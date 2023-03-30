package com.example.metajobs.post;


import com.example.metajobs.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public List<PostVO> postList(){
        return service.getPostList();
    }

    @GetMapping("/posts/{post_no}")
    public void postDetail(@RequestBody PostVO postVO){
        System.out.println("postVO값 가져오기"+ postVO);
        int result = service.insertPost(postVO);
        System.out.println("결과 확인 : " + result);
    }

    @PostMapping("/posts")
    public PostVO postInsert(@PathVariable Long id){
        PostVO post = service.getPost(id);
        System.out.println("결과 확인 : " + post);
        return post;
    }



    @DeleteMapping("/posts/{post_no}")
    public void postDelete(@PathVariable Long id){
        System.out.println("삭제할 id" +id);
        int result = service.postDelete(id);
        System.out.println("삭제 성공"+ result);
    }

    @PutMapping("/posts/{post_no}")
    public void postUpdate(@RequestBody PostVO postVO){
        System.out.println("postVO값 가져오기"+ postVO);
        int result = service.postUpdate(postVO);
        System.out.println("수정 성공 : " + result);
    }
}