package com.jwtdevelopment.jwttutorial.controller;

import com.jwtdevelopment.jwttutorial.service.JWTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final JWTService jwtService;
    public HomeController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping
    public String home() {
        return "Welcome to the JWT Tutorial!";
    }
    @PostMapping("/login")
    public String login() {
        return jwtService.getJWTToken();
    }
    @GetMapping("/user")
    public String user(@RequestParam  String token) {
        return jwtService.getUsername(token);
    }

}
