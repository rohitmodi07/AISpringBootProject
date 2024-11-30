package com.vlambo3.IASpringBootProject.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlambo3.IASpringBootProject.model.SentimentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SentimentService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private String apiKey;
    @Autowired
    private String sentimentUrl;
    @Autowired
    private String textToImageUrl;


    public List<SentimentResult> analyzeSentiment(String comment) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonBody = "{ \"inputs\": \"" + comment + "\" }";
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(sentimentUrl, request, String.class);
        System.out.println("Response JSON: " + response.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        SentimentResult[][] results = null;
        try {
            results = objectMapper.readValue(response.getBody(), SentimentResult[][].class);
        } catch (Exception e) {
            System.out.println(" error occurred :: "+e);
        }

        if (results != null && results.length > 0) {
            return Arrays.stream(results)
                    .flatMap(Arrays::stream)
                    .toList();
        }
        return null;
    }

    public ResponseEntity<byte[]> convertTextToImage(Map<String, String> data) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        ResponseEntity<byte[]> response = null;
        try {
            response = restTemplate.postForEntity(textToImageUrl, request, byte[].class);
        } catch (Exception e) {
            System.out.println(" error occurred :: "+e);
        }

        return response;
    }

}
