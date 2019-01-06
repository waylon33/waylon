package com.sunny.waylon.configuration;

import com.sunny.waylon.utils.RestTemplateUtils;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class SunnyConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SunnyConfiguration.class);

    @Value("${server.port}")
    private Integer httpsPort;

    @Value("${http.port}")
    private Integer httpPort;

    @Bean
    public void startConfiguration(){
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ start configuration ~~~~~~~~~~~~~~~~~~~~");
    }

    @Bean
    public RestTemplate restTemplate(){
        return RestTemplateUtils.get(30000,30000,30000,"UTF-8");
    }

//    @Bean
//    public RedisAutoConfiguration redisAutoConfiguration(){return new RedisAutoConfiguration();}

    @Bean
    public TomcatServletWebServerFactory servletContainerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    private Connector httpConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }

    @PostConstruct
    public void init(){
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ configuration start ~~~~~~~~~~~~~~~~~~~~");
        LOGGER.info("httpsPort: " + httpsPort + "\n" + "httpPort: " + httpPort);
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~ configuration end ~~~~~~~~~~~~~~~~~~~~");
    }
}
