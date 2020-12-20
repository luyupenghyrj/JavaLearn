package com.lyp.sentinel.example.Services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SentinelSyncServices {
    @Async
    public void helloSync(){
        System.out.println("异步开始-----");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步结束-----");
    }
}
