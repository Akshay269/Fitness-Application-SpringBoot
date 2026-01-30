package com.project.fitness.controller;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.service.RecommendationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.fitness.model.Recommendation;
import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request
    ) {

        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendation(
            @PathVariable String userId
    ) {

        List<Recommendation> recommendationList = recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }


    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getRecommendationByActivity(
            @PathVariable String activityId
    ) {

        List<Recommendation> recommendationList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }
}
