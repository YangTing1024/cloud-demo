package com.yang.order.feign;

import com.yang.prodect.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/10/9 上午8:25
 **/
@FeignClient(value = "service-product")
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long productId);

}
