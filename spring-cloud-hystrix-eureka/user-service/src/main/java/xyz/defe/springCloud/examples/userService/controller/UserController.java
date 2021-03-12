package xyz.defe.springCloud.examples.userService.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.defe.springCloud.examples.userService.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getOrderList")
    @HystrixCommand(fallbackMethod = "getOrderListFailed")
    public String getOrderList() {
        return userService.getOrderList();
    }

    public String getOrderListFailed() {
        return "get order list failed";
    }
}
