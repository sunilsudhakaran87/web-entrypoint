package org.sanjay.webentrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class WebEntrypointApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebEntrypointApplication.class, args);
    }

    /*
    @Bean
    public String loggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    */

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
