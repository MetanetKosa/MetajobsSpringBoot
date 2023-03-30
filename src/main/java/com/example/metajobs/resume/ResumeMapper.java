package com.example.metajobs.resume;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {

    public List<Resume> getList(Long mem_no);

    public Resume get(Long resume_no);

    public void resumeInsert(Resume resume);

    public void insertSelectKey(Resume resume);

    public int resumeUpdate(Resume resume);

    public int resumeDelete(Long resume_no);

}
