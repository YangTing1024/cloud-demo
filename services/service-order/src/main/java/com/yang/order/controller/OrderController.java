package com.yang.order.controller;

import com.yang.order.domain.Order;
import com.yang.order.properties.OrderProperties;
import com.yang.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:59
 **/
//@RefreshScope
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Value("${order.time-out}")
//    private String timeOut;
//
//    @Value("${order.startTime}")
//    private String startTime;

    @Autowired
    private OrderProperties orderProperties;

    @GetMapping("/config")
    public String getConfig() {
        return "time-out: " + orderProperties.getTimeOut() + " , startTime: " + orderProperties.getStartTime()
                + " , name: " + orderProperties.getName() + " , des: " + orderProperties.getDes();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {
        return orderService.createOrder(productId, userId);
    }

}
