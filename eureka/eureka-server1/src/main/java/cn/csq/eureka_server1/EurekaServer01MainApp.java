package cn.csq.eureka_server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author csq
 * @date 2020/11/14 15:14:53
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer01MainApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01MainApp.class, args);
    }
}
