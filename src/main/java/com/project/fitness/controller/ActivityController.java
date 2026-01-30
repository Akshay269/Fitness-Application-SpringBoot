package com.project.fitness.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;

import lombok.RequiredArgsConstructor;
import com.project.fitness.service.ActivityService;
import java.util.List;


@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest) {

        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader(value = "X-User-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

}
