package com.lyp.sentinel.example.Controller;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyp.sentinel.example.Services.SentinelSyncServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private SentinelSyncServices sentinelSyncServices;

    @GetMapping("async")
    public void helloSync(){
        AsyncEntry  asyncEntry=null;
        try {
            asyncEntry= SphU.asyncEntry("Sentinel_Async");
            sentinelSyncServices.helloSync();
        } catch (BlockException e) {
            System.out.println("系统繁忙,请稍后.");
        }finally {
            if (asyncEntry != null) {
                asyncEntry.exit();
            }
        }
    }
}
