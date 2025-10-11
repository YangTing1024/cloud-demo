package com.yang.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/10/11 上午8:33
 **/
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
