package com.example.metajobs.review;

import java.util.List;

public interface ReviewMapper {
    public List<ReviewVO> getList();

    public boolean reviewInsert(ReviewVO review);

    public ReviewVO get(long rno);

//    public List<ReviewVO> getListWithPaging(Criteria cri);


//    public int getTotalCount(Criteria cri);

    public int reviewDelete(long rno);

    public int reviewUpdate(ReviewVO review);
}
