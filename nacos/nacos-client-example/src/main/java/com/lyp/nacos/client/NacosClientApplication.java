package com.lyp.nacos.client;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class NacosClientApplication {
    public static void main(String[] args) throws NacosException {
        String serverAddr="127.0.0.1:8848";
        String dataId="nacos-client-example.yaml";
        String group="DEFAULT_GROUP";
        String namespace="3caca7ff-30d6-4a32-9841-c59b20dfa17a";
        Properties properties=new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR,serverAddr);
        properties.put(PropertyKeyConst.NAMESPACE,namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, group, 5000);

        System.out.println("value="+config);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
