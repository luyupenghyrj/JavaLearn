package com.lyp.nacos.example.spring.boot;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//可以使用注解的方式配置服务中心地址
//@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
public class NacosDisconveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDisconveryApplication.class, args);
    }
}
