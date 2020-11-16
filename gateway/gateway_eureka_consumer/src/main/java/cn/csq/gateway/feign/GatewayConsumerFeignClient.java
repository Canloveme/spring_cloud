package cn.csq.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author csq
 * @date 2020/11/15 19:45:34
 */
@FeignClient(value = "GATEWAY-EUREKA-PROVIDER", configuration = FeignLogConfig.class)
public interface GatewayConsumerFeignClient {

    @GetMapping("/gateway/provider/{id}")
    String gatewayConsumerFeignClient(@PathVariable("id") String id);
}
