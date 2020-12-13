package com.lyp.nacos.example.spring.cloud.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( path = "/order")
public class EchoController {
    @GetMapping(value = "/product/{name}")
    public String getOrder(@PathVariable String name){
        return "Hello:"+name;
    }
}
