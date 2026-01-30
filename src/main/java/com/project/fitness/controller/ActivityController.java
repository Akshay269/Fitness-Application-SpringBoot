package com.project.fitness.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/activities")

public class ActivityController {
    
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(){
        return ""
    }

    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
