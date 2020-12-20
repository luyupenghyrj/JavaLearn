package com.lyp.sentinel.example.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnController {

    @GetMapping("annSentinel")
    @SentinelResource(value = "Sentinel_Ann", blockHandler = "expHandler")
    public String hello() {
        return "Hello Sentinel.";
    }
    public String expHandler(BlockException ex){
        ex.printStackTrace();
        return "系统繁忙,请稍后再试.";
    }
}
