package xyz.defe.springCloud.examples.serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    public RestTemplate rest;

    @GetMapping("test")
    public String test() {
        String response = rest.getForObject("http://localhost:8082/service-b/test", String.class);
        return response;
    }
}
