package cn.csq.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author csq
 * @date 2020/11/15 11:48:24
 */
@EnableEurekaServer
@SpringBootApplication
public class FeignEurekaServerMainApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaServerMainApp.class, args);
    }
}
