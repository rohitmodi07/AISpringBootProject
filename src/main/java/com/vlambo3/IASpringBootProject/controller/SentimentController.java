package com.vlambo3.IASpringBootProject.controller;

import com.vlambo3.IASpringBootProject.model.SentimentRequest;
import com.vlambo3.IASpringBootProject.model.SentimentResult;
import com.vlambo3.IASpringBootProject.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SentimentController {
    @Autowired
    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @PostMapping(value = "/sentiment/analyze", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SentimentResult> analyzeSentiment(@RequestBody SentimentRequest request) {
        return sentimentService.analyzeSentiment(request.getComment());
    }

    @PostMapping(value = "/timage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> processTextToImage(@RequestBody Map<String, String> data) {
        return sentimentService.convertTextToImage(data);
    }
}
