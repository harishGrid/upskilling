package com.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Hello, Admin!";
    }
}
