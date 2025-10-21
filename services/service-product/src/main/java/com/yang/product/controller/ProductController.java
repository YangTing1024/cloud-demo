package com.yang.product.controller;

import com.yang.prodect.domain.Product;
import com.yang.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    public Product getProductById(@PathVariable("id") Long productId,
                                  HttpServletRequest request){
        String header = request.getHeader("X-Token");
        System.out.println("ProductController.getProductById ....." + header);
//        int i = 1/0;
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productService.getProductById(productId);
    }

}
