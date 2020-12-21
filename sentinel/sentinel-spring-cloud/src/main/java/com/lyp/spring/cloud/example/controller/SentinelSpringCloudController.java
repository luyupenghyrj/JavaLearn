package com.lyp.spring.cloud.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelSpringCloudController {
    @GetMapping("sentinelCloud")
    @SentinelResource(value = "Sentinel_Cloud",blockHandler = "sentinelHandler",fallback = "sentinelFallback")
    public String SentinelCloud(){
        return "Hello Sentinel.";
    }
    public String sentinelHandler(BlockException ex){
        ex.printStackTrace();
        return "Handler系统繁忙,请稍后再试.";
    }
    public String sentinelFallback(BlockException ex){
        ex.printStackTrace();
        return "Fallback系统繁忙,请稍后再试.";
    }
}
