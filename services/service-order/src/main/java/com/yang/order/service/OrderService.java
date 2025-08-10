package com.yang.order.service;

import com.yang.order.domain.Order;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午6:00
 **/
public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
