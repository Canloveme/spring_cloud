package cn.csq.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author csq
 * @date 2020/11/15 19:59:32
 */
@EnableEurekaClient
@SpringBootApplication
// 开启Hystrix仪表盘监控功能
public class GatewayServerMainApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerMainApp.class, args);
    }
}
