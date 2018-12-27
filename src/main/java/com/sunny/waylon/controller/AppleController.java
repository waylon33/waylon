package com.sunny.waylon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apple")
public class AppleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppleController.class);

    @GetMapping(value = "/getApple")
    public String testController(){
        if (LOGGER.isDebugEnabled()){
            LOGGER.info("receive a request");
        }
        LOGGER.info("receive a request");
        return "an apple";
    }
}
