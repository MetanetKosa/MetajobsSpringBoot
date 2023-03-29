package com.example.metajobs.post;


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
    public List<PostVO> getPostList(){
        return service.getPostList();
    }

//    @GetMapping(value = "/postDetail")
//    public String postDetail(Model model, @RequestParam Long post_no ) {
//        model.addAttribute("post", service.getPost(post_no));
//        log.info("postDetail 결과확인: "+ service.getPost(post_no));
//        return "/post/postDetail";
//    }

    @GetMapping("/post/{id}")
    public PostVO postDetail(@PathVariable Long id){
        PostVO post = service.getPost(id);
        System.out.println("결과 확인 : " + post);
        return post;
    }

    @PostMapping("/post/postInsert")
    public void postDetail(@RequestBody PostVO postVO){
        System.out.println("postVO값 가져오기"+ postVO);
        int result = service.insertPost(postVO);
        System.out.println("결과 확인 : " + result);
    }

    @DeleteMapping("/post/postDelete/{id}")
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