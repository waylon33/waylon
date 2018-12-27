package com.sunny.waylon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping(value = "/orange")
public class OrangeController {

    private static final Logger LOGGER = LoggerFactory.getLogger("i am orange");

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/getOrange")
    public String testController(){
        if (LOGGER.isDebugEnabled()){
            LOGGER.info("receive a request");
        }
        LOGGER.info("receive a request");
        URI uri = URI.create("http://localhost:8080/apple/getApple");
        ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);
        return "an orange and " + result.getBody() + "and" + System.getenv("DOG");
    }
}
