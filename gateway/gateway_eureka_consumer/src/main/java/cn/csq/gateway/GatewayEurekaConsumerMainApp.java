package cn.csq.gateway;

import cn.csq.gateway.feign.GatewayConsumerFeignClient;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 19:40:09
 */

//开启feign
@EnableFeignClients
//服务发现
@EnableEurekaClient
//服务降级
@EnableCircuitBreaker
//服务发现
@EnableDiscoveryClient
@EnableHystrixDashboard
@RestController
@SpringBootApplication
public class GatewayEurekaConsumerMainApp {

    @Autowired
    public GatewayConsumerFeignClient gateWayConsumer;

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/gateway/consumer/{id}")
    public String gateWayConsumer(@PathVariable("id") String id) {
        return gateWayConsumer.gatewayConsumerFeignClient(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayEurekaConsumerMainApp.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
