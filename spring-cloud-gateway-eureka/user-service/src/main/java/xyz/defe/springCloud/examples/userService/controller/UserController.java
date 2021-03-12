package xyz.defe.springCloud.examples.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("list")
    public String getUserList() {
        return "get from user-service:getUserList()";
    }
}
