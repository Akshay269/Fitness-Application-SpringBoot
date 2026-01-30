package com.project.fitness.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecommendationRequest {
    
    private String userId;

    private String activityId;  
    
    private List<String> safety;

    private List<String> improvements;

    private List<String> suggestions;
}
