package com.yang.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * @Description: OrderProperties
 * @Author: YangTing
 * @Date: 2025/8/20 下午9:37
 **/
@Data
@ConfigurationProperties(prefix = "order")
@Component
public class OrderProperties {

    private String timeOut;

    private String startTime;

    private String name;
}
