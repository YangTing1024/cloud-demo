package com.yang.order.service.impl;

import com.yang.order.domain.Order;
import com.yang.order.service.OrderService;
import com.yang.prodect.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 下午6:00
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductByIdRemoteWithLoadBalanceAnnotation(productId);
        Order order = new Order();
        order.setId(1L);
        //总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setNickName("杨汀");
        order.setAddress("杭州市");
        //远程查询商品列表
        order.setProductList(Arrays.asList(product));
        return order;
    }

    /**
     * 版本3-注解负载均衡
     */
    private Product getProductByIdRemoteWithLoadBalanceAnnotation(Long productId){
        String url = "http://service-product/product/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }

    /**
     * 版本2-手动负载均衡
     */
    private Product getProductByIdRemoteWithLoadBalance(Long productId){
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        String url = "http://" +  choose.getHost() + ":" + choose.getPort() + "/product/" + productId;
        log.info("远程调用url:" + url);
        return restTemplate.getForObject(url, Product.class);
    }

    /**
     * 版本1-原始远程调用
     */
    private Product getProductByIdRemote(Long productId){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instanceList.get(0);
        String url = "http://" +  instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程调用url:" + url);
        return restTemplate.getForObject(url, Product.class);
    }
}