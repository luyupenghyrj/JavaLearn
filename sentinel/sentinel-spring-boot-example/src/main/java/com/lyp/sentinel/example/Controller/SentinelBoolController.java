package com.lyp.sentinel.example.Controller;

import com.alibaba.csp.sentinel.SphO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelBoolController {
    @GetMapping("/SentinelBool")
    public boolean SentinelHello() {
        if (SphO.entry("Sentinel_Boolean")) {
            System.out.println("访问成功.");
            try {
                return true;
            } finally {
                SphO.exit();
            }
        } else {
            System.out.println("系统繁忙,请稍后.");
            return false;
        }
    }
}
