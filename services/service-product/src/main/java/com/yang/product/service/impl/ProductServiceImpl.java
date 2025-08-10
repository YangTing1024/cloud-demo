package com.yang.product.service.impl;

import com.yang.product.domain.Product;
import com.yang.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:38
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setName("西瓜");
        product.setPrice(new BigDecimal(100));
        product.setNum(7);
        return product;
    }
}
