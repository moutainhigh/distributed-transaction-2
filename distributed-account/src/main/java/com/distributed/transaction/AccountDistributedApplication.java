package com.distributed.transaction;

import com.distributed.transaction.config.HttpClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*
* @author ssk www.8win.com Inc.All rights reserved
* @date 2018/08/03 下午 2:27
* @since v1.0
**/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.distributed.transaction.account" ,"com.distributed.transaction.trade" })
//@EnableJpaRepositories(basePackages = "com.hnapay.fcs.gateway.base")
//@EntityScan(basePackages = "com.hnapay.fcs.gateway.entity")
@ImportAutoConfiguration(classes = HttpClientConfig.class)
public class AccountDistributedApplication {

    public static void main(String[] args) {

        SpringApplication.run(AccountDistributedApplication.class, args);
    }
}
