package com.example.metajobs.review;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    public List<ReviewVO> getList();

    public boolean reviewInsert(ReviewVO review);

    public ReviewVO get(long rno);

//    public List<ReviewVO> getListWithPaging(Criteria cri);


//    public int getTotalCount(Criteria cri);

    public int reviewDelete(long rno);

    public int reviewUpdate(ReviewVO review);
}
