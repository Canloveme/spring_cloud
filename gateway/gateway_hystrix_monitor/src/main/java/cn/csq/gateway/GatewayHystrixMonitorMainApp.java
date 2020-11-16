package cn.csq.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author csq
 * @date 2020/11/15 20:52:51
 */
//开启Turibine
@EnableTurbine
//开启Hystrix仪表盘监控功能
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class GatewayHystrixMonitorMainApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayHystrixMonitorMainApp.class, args);
    }
}
