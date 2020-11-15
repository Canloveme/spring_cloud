package cn.csq.feign.controller;

import cn.csq.feign.config.FeignLogConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author csq
 * @date 2020/11/15 11:38:41
 */
@FeignClient(value = "FEIGN-PROVIDER", configuration = FeignLogConfig.class)
public interface ProviderFeignClient {

    @GetMapping("/feign/provider")
    String feignProvider();

}
