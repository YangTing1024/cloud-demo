package com.yang.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/*
 * @Description: Order
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:58
 **/
@Data
public class Order {

    private Long id;

    private BigDecimal totalAmount;

    private String nickName;

    private String address;

    private List<Object> productList;

}
