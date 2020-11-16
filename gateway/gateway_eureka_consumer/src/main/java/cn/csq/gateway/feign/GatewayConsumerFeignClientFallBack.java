package cn.csq.gateway.feign;

import org.springframework.stereotype.Component;

/**
 * @author csq
 * @date 2020/11/15 20:23:06
 */
@Component
public class GatewayConsumerFeignClientFallBack implements GatewayConsumerFeignClient{
    @Override
    public String gatewayConsumerFeignClient(String id) {
        return "gatewayConsumerFeignClient fallBack Method id:" + id;
    }

}
