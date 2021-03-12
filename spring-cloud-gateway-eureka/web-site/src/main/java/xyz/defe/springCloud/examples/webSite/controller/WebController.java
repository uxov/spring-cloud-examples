package xyz.defe.springCloud.examples.webSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@ConfigurationProperties
public class WebController {
    @Autowired
    private RestTemplate rest;

    @Value("${gateway.url}")
    private String gatewayUrl;

    @GetMapping("user/list")
    public String getUserList() {
        String response = rest.getForObject( gatewayUrl + "/user/list", String.class);
        return response;
    }

    @GetMapping("order/list")
    public String getOrderList() {
        String response = rest.getForObject( gatewayUrl + "/order/list", String.class);
        return response;
    }
}
