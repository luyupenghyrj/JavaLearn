package com.lyp.nacos.example.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope//通过注解方式自动刷新
public class ConfigController {

    @Value("${useLocalCache:haha}")
    private String useLocalCache;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }
    @RequestMapping("/getPlus")
    public String getPlus() {
        return applicationContext.getEnvironment().getProperty("useLocalCache");
    }
    @RequestMapping("/getExtConfig")
    public String getExtConfig() {
        return applicationContext.getEnvironment().getProperty("name");
    }
}