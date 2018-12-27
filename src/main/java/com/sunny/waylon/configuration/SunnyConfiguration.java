package com.sunny.waylon.configuration;

import com.sunny.waylon.utils.RestTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class SunnyConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SunnyConfiguration.class);

//    @Bean
//    public void startConfiguration(){
//        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ start configuration ~~~~~~~~~~~~~~~~~~~~");
//    }

    @Bean
    public RestTemplate restTemplate(){
        return RestTemplateUtils.get(30000,30000,30000,"UTF-8");
    }

//    @Bean
//    public RedisAutoConfiguration redisAutoConfiguration(){return new RedisAutoConfiguration();}

    @PostConstruct
    public void init(){
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ configuration start ~~~~~~~~~~~~~~~~~~~~");
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ configuration end ~~~~~~~~~~~~~~~~~~~~");
    }
}
