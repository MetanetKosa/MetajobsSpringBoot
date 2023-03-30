package com.example.metajobs.post;

import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<PostVO> getPostList() {
        return postMapper.getPostList();
    }
    public PostVO getPost(Long postNo){
        return postMapper.getPost(postNo);
    }

    public int insertPost(PostVO postVO){
        return postMapper.postInsert(postVO);
    }

    public int postDelete(Long postNo){
        return postMapper.postDelete(postNo);
    }

    public int postUpdate(PostVO postNo){
        return postMapper.postUpdate(postNo);
    }
}
