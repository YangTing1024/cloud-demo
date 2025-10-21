package com.yang.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yang.order.domain.Order;
import com.yang.order.properties.OrderProperties;
import com.yang.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @GetMapping("/secKill")
    @SentinelResource(value = "secKill-order", fallback = "secKillFallback")
    public Order secKill(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {
        return orderService.createOrder(productId, userId);
    }

    public Order secKillFallback(Long productId, Long userId, Throwable e) {
        System.out.println("secKillFallback ...");
        Order order = new Order();
        order.setId(productId);
        order.setNickName("secKillFallback兜底回调商品");
        order.setAddress("异常信息：" + e.getMessage());
        return order;
    }

    @GetMapping("readDb")
    public String readDb() {
        log.info("readDb ...");
        return "readDb ...";
    }

    @GetMapping("writeDb")
    public String writeDb() {
        return "writeDb ...";
    }
}
