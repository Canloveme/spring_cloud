package cn.csq.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 11:51:57
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class FeignEurekaProviderMainApp {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/feign/provider")
    public String feignEurekaProvider() {
        return "feign Eureka Provider: " + serverPort;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaProviderMainApp.class, args);
    }
}
