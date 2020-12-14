package com.lyp.nacos.example.spring.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( name = "service-provider")
@RequestMapping( path = "/order")
public interface ClientFeign {
    @GetMapping(value = "/product/{name}")
    String getOrder(@PathVariable(value = "name") String namea);
}
