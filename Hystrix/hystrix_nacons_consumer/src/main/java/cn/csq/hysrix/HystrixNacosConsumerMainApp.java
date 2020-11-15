package cn.csq.hysrix;

import cn.csq.hysrix.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 15:31:53
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign的功能
public class HystrixNacosConsumerMainApp {

  /*  @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
*/
/*    @GetMapping("/hystrix/consumer")
    public String consumer() {
        String url = "http://localhost:8000/hystrix/provider";
        return restTemplate().getForObject(url, String.class);
    }*/

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/hystrix/consumer/{id}")
        public String consumer(@PathVariable("id") String id) {
        return providerFeignClient.hystrixProvider(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(HystrixNacosConsumerMainApp.class, args);
    }
}
