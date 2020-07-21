package com.dzc.platoomcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author dzc
 * @date 2020/7/21
 */
@SpringBootApplication
@EnableZuulProxy   //开启zuul网关代理
public class PlatoomCloudGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatoomCloudGateWayApplication.class,args);
    }
}
