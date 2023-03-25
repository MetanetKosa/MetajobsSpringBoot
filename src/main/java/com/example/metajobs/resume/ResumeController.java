package com.example.metajobs.resume;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {

    private ResumeService  service;

    public ResumeController(ResumeService service) {
        this.service = service;
    }
}
