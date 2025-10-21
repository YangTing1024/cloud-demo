package com.yang.order.feign.fallback;

import com.yang.order.feign.ProductFeignClient;
import com.yang.prodect.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/10/13 上午8:05
 **/
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(Long productId) {
        System.out.println("兜底回调......");
        Product product = new Product();
        product.setId(productId);
        product.setName("默认商品");
        product.setPrice(new BigDecimal(100));
        product.setNum(10);
        return product;
    }
}
