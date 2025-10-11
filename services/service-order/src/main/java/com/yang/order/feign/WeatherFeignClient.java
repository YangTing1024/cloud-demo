package com.yang.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @Description: 远程调用三方API（https://www.juhe.cn/docs/api/id/73）
 * @Author: YangTing
 * @Date: 2025/10/10 上午7:37
 **/
@FeignClient(value = "weather-client", url = "http://apis.juhe.cn")
public interface WeatherFeignClient {

    @PostMapping("/simpleWeather/query")
    String getWeather(@RequestHeader("Content-Type") String contentType,
                      @RequestParam("city") String city,
                      @RequestParam("key")String key);

}
