package xyz.defe.springCloud.examples.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate rest;

    @Value("${order-service.url}")
    private String orderServiceUrl;

    public String getOrderList() {
        String response = rest.getForObject(orderServiceUrl + "order/list", String.class);
        return response;
    }
}
