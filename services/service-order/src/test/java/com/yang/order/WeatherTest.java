package com.yang.order;

import com.yang.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @Description: 远程调用第三方天气API测试
 * @Author: YangTing
 * @Date: 2025/10/10 上午7:45
 **/
@SpringBootTest
public class WeatherTest {

    @Autowired
    private WeatherFeignClient weatherFeignClient;

    @Test
    public void testWeather() {
        String weather = weatherFeignClient.getWeather("application/x-www-form-urlencoded", "厦门", "a06ee4a356d298195c0c12558c8eb4c6");
        System.out.println("天气是：" + weather);
    }

}
