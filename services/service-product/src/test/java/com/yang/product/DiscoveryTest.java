package com.yang.product;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/*
 * @Description: 服务发现测试
 * @Author: YangTing
 * @Date: 2025/8/9 下午3:54
 **/
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    /**
     * 服务发现：nacosServiceDiscovery方式
     */
    @Test
    void nacosServiceDiscoveryTest() throws NacosException {
            List<String> services = nacosServiceDiscovery.getServices();
            for (String service : services){
                System.out.println("service : " + service);
                List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
                for (ServiceInstance instance : instances){
                    System.out.println("ip : " + instance.getHost() + ",port : " + instance.getPort());
                }
            }
    }

    /**
     * 服务发现：discoveryClient方式
     */
    @Test
    void discoveryClientTest(){
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            System.out.println("service : " + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances){
                System.out.println("ip : " + instance.getHost() + ",port : " + instance.getPort());
            }
        }
    }
}
