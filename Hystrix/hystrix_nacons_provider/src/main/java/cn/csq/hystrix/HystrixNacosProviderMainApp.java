package cn.csq.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csq
 * @date 2020/11/15 15:25:37
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
//开启Hystrix功能
@EnableCircuitBreaker
public class HystrixNacosProviderMainApp {


    @Value("${server.port}")
    public String serverPort;


    /**
     * 服务降级：1.出现异常 2.超时
     * @return
     */
    @GetMapping("/hystrix/provider/{id}")
    @HystrixCommand(fallbackMethod = "hystrixProviderFallBack",commandProperties = {
            //设置Hystrix的超时时间，默认1s
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String hystrixProvider(@PathVariable("id") String id) {
        if (id.equals("1")) {
            //如果访问id为1得，服务就降级
            //创建异常
            int x = 0 / 0;
        }
        return "hystrixProviderMethod:" + serverPort + " id为：" + id;
    }

    public String hystrixProviderFallBack(@PathVariable("id") String id){
        return "hystrixProviderFallBackMethod:" + serverPort + " id为1，服务降级";
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixNacosProviderMainApp.class, args);
    }
}
