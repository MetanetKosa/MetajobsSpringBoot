package com.example.metajobs.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeMapper mapper;

    @Override
    public void insertResume(Resume resume) {
        mapper.resumeInsert(resume);
    }

    @Override
    public Resume get(Long resume_no) {
        return mapper.get(resume_no);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return mapper.resumeUpdate(resume) == 1;
    }

    @Override
    public boolean delete(Long resume_no) {
        return mapper.resumeDelete(resume_no) == 1;
    }

    @Override
    public List<Resume> getResumeList(Long mem_no) {
        return mapper.getList(mem_no);
    }
}
