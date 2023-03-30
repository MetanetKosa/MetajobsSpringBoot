package com.example.metajobs.resume;

import java.util.List;

public interface ResumeService {
    public void insertResume(Resume resume);
    public Resume get(Long resume_no);
    public boolean updateResume(Resume resume);
    public boolean delete(Long resume_no);
    public List<Resume> getResumeList(Long mem_no);

}
