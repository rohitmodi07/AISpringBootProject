package com.vlambo3.IASpringBootProject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SentimentResult {
    private String label;
    private double score;
}
