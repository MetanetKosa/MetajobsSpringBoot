package com.example.metajobs.resume;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResumeController {

    private ResumeService  service;

    public ResumeController(ResumeService service) {
        this.service = service;
    }
    //이력서 등록
    @PostMapping("/users/{mem_no}/resumes")
    public void insert(@PathVariable Long mem_no, @RequestBody Resume resume){
        resume.setMem_no(mem_no);
        service.insertResume(resume);
    }

    //이력서 목록
    @GetMapping("/users/{mem_no}/resumes")
    public List<Resume> list(@PathVariable Long mem_no){

        return service.getResumeList(mem_no);
    }

    //이력서 상세조회
    @GetMapping("/users/{id}/resumes/{resume_no}")
    public Resume get(@PathVariable Long id,@PathVariable Long resume_no){
        return service.get(resume_no);
    }

    @DeleteMapping("/users/{id}/resumes/{resume_no}")
    public void delete(@PathVariable Long id,@PathVariable Long resume_no){
        service.delete(resume_no);
    }
}
