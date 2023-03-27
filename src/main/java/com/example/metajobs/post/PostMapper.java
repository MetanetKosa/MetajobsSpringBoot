package com.example.metajobs.post;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<PostVO> getPostList();
    public PostVO getPost(Long postNo);

    public int postInsert(PostVO postVO);
}
