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

    @GetMapping("/post")
    public List<PostVO> postList(){
        return service.getPostList();
    }

//    @GetMapping(value = "/postDetail")
//    public void postDetail(@RequestBody PostVO postVO){
//        System.out.println("postVO값 가져오기"+ postVO);
//        int result = service.insertPost(postVO);
//        System.out.println("결과 확인 : " + result);
//    }

    @GetMapping("/post/{id}")
    public PostVO postDetail(@PathVariable Long id){
        PostVO post = service.getPost(id);
        System.out.println("결과 확인 : " + post);
        return post;
    }

    @PostMapping("/post/postInsert")
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

    @PostMapping("/post/postUpdate")
    public void postUpdate(@RequestBody PostVO postVO){
        System.out.println("postVO값 가져오기"+ postVO);
        int result = service.postUpdate(postVO);
        System.out.println("수정 성공 : " + result);
    }
}