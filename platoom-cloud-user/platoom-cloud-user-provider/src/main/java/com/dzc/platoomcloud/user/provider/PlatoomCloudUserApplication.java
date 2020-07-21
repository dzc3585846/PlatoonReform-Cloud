package com.dzc.platoomcloud.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dzc
 * @date 2020/7/21
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dzc.platoomcloud.user.api","com.dzc.platoomcloud.user.biz","com.dzc.platoomcloud.user.provider.service"})
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableFeignClients// 该注解是开启feign的扫描。
public class PlatoomCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatoomCloudUserApplication.class,args);
    }
}
