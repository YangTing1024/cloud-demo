package com.yang.product.controller;

import com.yang.prodect.domain.Product;
import com.yang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午5:31
 **/
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        System.out.println("ProductController.getProductById");
        return productService.getProductById(productId);
    }

}
