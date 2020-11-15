package cn.csq.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 11:39:35
 */
@RestController
@RequestMapping("/feign")
public class ConsumerController {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/consumer")
    public String feignConsumer(){
        return providerFeignClient.feignProvider();
    }
}
