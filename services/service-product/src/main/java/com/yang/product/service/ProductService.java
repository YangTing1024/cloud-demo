package com.yang.product.service;

import com.yang.product.domain.Product;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:38
 **/
public interface ProductService {
    Product getProductById(Long productId);
}
