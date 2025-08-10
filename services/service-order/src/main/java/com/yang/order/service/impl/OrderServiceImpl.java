package com.yang.order.service.impl;

import com.yang.order.domain.Order;
import com.yang.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午6:00
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        order.setId(1L);
        //todo 总金额
        order.setTotalAmount(new BigDecimal(0));
        order.setNickName("杨汀");
        order.setAddress("杭州市");
        //todo 远程查询商品列表
        order.setProductList(null);
        return order;
    }
}
