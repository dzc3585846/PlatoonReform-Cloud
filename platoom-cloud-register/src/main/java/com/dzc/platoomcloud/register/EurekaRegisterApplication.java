package com.dzc.platoomcloud.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dzc
 * @date 2020/7/21
 */
@SpringBootApplication
@EnableEurekaServer // 注册中心服务
public class EurekaRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterApplication.class,args);
    }
}
