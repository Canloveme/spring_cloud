package cn.csq.hysrix.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author csq
 * @date 2020/11/15 15:53:47
 */
@Component
public class HystrixProviderFeignClientFallBack implements ProviderFeignClient {

    @Override
    public String hystrixProvider(@PathVariable("id") String id) {
        return "HystrixFeignClientConsumerFallBack";
    }

}
