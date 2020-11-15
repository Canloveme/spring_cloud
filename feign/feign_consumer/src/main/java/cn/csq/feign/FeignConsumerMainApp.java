package cn.csq.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author csq
 * @date 2020/11/15 11:36:48
 */
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients //开启Feign的功能
@SpringBootApplication
public class FeignConsumerMainApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerMainApp.class, args);
    }
}
