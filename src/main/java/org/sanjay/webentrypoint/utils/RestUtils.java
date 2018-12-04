package org.sanjay.webentrypoint.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestUtils {
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger("org.sanjay.webentrypoint.utils.RestUtils");

    public Object doPost(String url, Object payload) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<Object> entityRequest = new HttpEntity<>(payload, httpHeaders);

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, entityRequest, Object.class);

        logger.info("Body type returned by Booking Service: " + responseEntity.getBody().getClass().getName());
        return responseEntity.getBody();
    }
}
