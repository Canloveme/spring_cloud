package cn.csq.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author csq
 * @date 2020/11/15 09:41:56
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class NacosConsumerMainApp {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/nacos/consumer")
    public String consumer() {
        String url = "http://127.0.0.1:8000/nacos/provider";
        return restTemplate().getForObject(url, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMainApp.class, args);
    }
}
