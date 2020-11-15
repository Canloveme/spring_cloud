package cn.csq.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 09:39:22
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosProviderMainApp {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/nacos/provider")
    public String provider() {
        return "Nacos Provider: " + serverPort;
    }


    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMainApp.class, args);
    }
}
