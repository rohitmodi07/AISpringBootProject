# Sentiment Analysis and Text to Image Generation Project

This project is a simple Spring Boot application that uses Hugging Face's DistilBERT model and text to image 
generation black forest labs model for sentiment analysis and generating image.

## Features

- Spring Boot REST API
- Sentiment Analysis using Hugging Face's DistilBERT model
- Text to Image generation using Hugging Face's black forest labs model
- Easy to set up and deploy

## Requirements

- Java 17
- Maven
- A Hugging Face API key
  To generate a token in HuggingFace follow the steps
    -- Go to Hugging Face website and create an account
    -- after that click on your profile picture, it will show multiple options, one of the option
       will be "Access Tokens"
    -- click on Access Token and generate a token
    -- copy this token and move to your project, open application.properties file and paste this token against
       the key "apiKey"

## Project Flow

Following features has been added in this project

1. application exposes a REST API (/sentiment/analyze) endpoint that takes a text comment as input and returns the sentiment (positive or negative) with the associated score.

    Example curl for postman - 
    
    curl -X 'POST' \
    'http://localhost:8080/sentiment/analyze' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
    "comment": "This show was so so so much better than I expected."
    }'
    
    if you want to use swagger ui, then open 'http://localhost:8080/swagger-ui.html'
    
    and then for '/sentiment/analyze' pass following body as request
    
    {
    "comment": "This show was so so so much better than I expected."
    }
    
    Response -
     [
       {
         "label": "POSITIVE",
         "score": 0.9995633959770203
       },
       {
         "label": "NEGATIVE",
         "score": 0.00043662337702699006
       }
     ]
2. application exposes a REST API (/timage) endpoint that takes a text comment as input and returns the AI generated image.

   Example curl for **postman** -

   curl -X 'POST' \
   'http://localhost:8080/timage' \
   -H 'accept: */*' \
   -H 'Content-Type: application/json' \
   -d '{
   "inputs": "post apocalyptic earth"
   }'

   if you want to use **swagger ui**, then open 'http://localhost:8080/swagger-ui.html'

   and then for '/sentiment/analyze' pass following body as request

   {
     "inputs": "post apocalyptic earth"
   }

   Response - 
           A generated image
          
