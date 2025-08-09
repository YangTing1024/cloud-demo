package com.yang.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 上午11:07
 **/
@EnableDiscoveryClient //开启服务注册与发现
@SpringBootApplication
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
    }
}
