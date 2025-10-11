package com.yang.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/16 下午5:10
 **/
@Configuration
public class OrderConfig {

    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
