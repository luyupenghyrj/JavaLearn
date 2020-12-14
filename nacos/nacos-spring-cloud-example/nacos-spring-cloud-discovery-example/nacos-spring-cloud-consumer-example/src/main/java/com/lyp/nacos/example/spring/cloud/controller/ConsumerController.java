package com.lyp.nacos.example.spring.cloud.controller;

import com.lyp.nacos.example.spring.cloud.feign.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    //private final RestTemplate restTemplate;

    private final ClientFeign clientFeign;

    public ConsumerController(ClientFeign clientFeign) {
        this.clientFeign = clientFeign;
    }
    //@Autowired
    //public ConsumerController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

//    @RequestMapping(value = "/order/{str}", method = RequestMethod.GET)
//    public String echo(@PathVariable String str) {
//        return restTemplate.getForObject("http://service-provider/order/product/" + str, String.class);
//    }
    @RequestMapping(value = "/order/{name}", method = RequestMethod.GET)
    public String getProduct(@PathVariable String name) {
        return clientFeign.getOrder(name);
    }
}
