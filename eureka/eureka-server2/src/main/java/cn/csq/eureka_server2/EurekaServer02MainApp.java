package cn.csq.eureka_server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author csq
 * @date 2020/11/14 15:36:31
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02MainApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02MainApp.class, args);
    }

}
