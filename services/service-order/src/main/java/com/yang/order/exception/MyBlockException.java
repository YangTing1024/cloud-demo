package com.yang.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/*
 * @Description: Sentinel自定义拦截器
 * @Author: YangTing
 * @Date: 2025/10/14 上午8:10
 **/
@Component
public class MyBlockException implements BlockExceptionHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s, BlockException e) throws Exception {
        httpServletResponse.setStatus(429);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        R error = R.error(500, s + "被Sentinel限制了：" + e.getClass());
        String json = objectMapper.writeValueAsString(error);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
