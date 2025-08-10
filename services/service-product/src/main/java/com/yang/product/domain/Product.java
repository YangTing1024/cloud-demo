package com.yang.product.domain;

import lombok.Data;

import java.math.BigDecimal;

/*
 * @Description: Product
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:33
 **/
@Data
public class Product {

    private Long id;

    private BigDecimal price;

    private String name;

    private int num;
}
