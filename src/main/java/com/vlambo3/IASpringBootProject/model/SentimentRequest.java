package com.vlambo3.IASpringBootProject.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SentimentRequest {
    private String comment;
}
