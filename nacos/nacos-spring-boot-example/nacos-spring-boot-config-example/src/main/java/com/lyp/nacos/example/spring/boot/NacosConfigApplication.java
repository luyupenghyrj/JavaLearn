package com.lyp.nacos.example.spring.boot;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "nacos-demo",autoRefreshed = true)
public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                NacosConfigApplication.class, args
        );
    }
}
