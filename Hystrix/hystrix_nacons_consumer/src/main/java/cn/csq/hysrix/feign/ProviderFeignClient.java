package cn.csq.hysrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author csq
 * @date 2020/11/15 15:51:49
 */

@FeignClient(value = "hystrix-nacos-provider", fallback = HystrixProviderFeignClientFallBack.class)
public interface ProviderFeignClient {

    @GetMapping("/hystrix/provider/{id}")
    String hystrixProvider(@PathVariable("id") String id);
}
