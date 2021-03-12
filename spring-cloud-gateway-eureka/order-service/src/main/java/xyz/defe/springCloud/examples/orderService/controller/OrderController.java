package xyz.defe.springCloud.examples.orderService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("list")
    public String getOrderList() {
        return "get from order-service:getOrderList()";
    }
}
