package com.example.metajobs.resume;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ResumeController {

    private ResumeService  service;

    public ResumeController(ResumeService service) {
        this.service = service;
    }
    //이력서 등록
    @PostMapping("/users/{id}/resumes")
    public ResponseEntity insert(@Valid @PathVariable Long mem_no, @RequestBody Resume resume){
        resume.setMem_no(mem_no);
        service.insertResume(resume);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //이력서 목록
    @GetMapping("/users/{id}/resumes")
    public List<Resume> list(@PathVariable Long mem_no){

        return service.getResumeList(mem_no);
    }

    //이력서 상세조회
    @GetMapping("/users/{id}/resumes/{resume_no}")
    public EntityModel<Resume> get(@PathVariable Long id, @PathVariable Long resume_no){
        Resume resume = service.get(resume_no);
        return EntityModel.of(resume, linkTo(methodOn(ResumeController.class).list(id)).withRel("all-resumes"));
    }

    @DeleteMapping("/users/{id}/resumes/{resume_no}")
    public void delete(@PathVariable Long mem_no,@PathVariable Long resume_no){
        service.delete(resume_no);
    }

    @PutMapping("/users/{id}/resumes/{resume_no}")
    public void update(@PathVariable Long mem_no,@PathVariable Long resume_no, @RequestBody Resume resume){
        resume.setMem_no(mem_no);
        resume.setResume_image("image1");
        resume.setResume_no(resume_no);
        service.updateResume(resume);
    }
}
