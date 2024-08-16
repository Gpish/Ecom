package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
class MiscellaneousController {
    
    @RequestMapping("/hello") 
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}") 
    public String greet(@PathVariable("name") String name) {
        return "Hello " + name;
    }
}