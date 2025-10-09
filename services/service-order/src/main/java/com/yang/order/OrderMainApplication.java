package com.yang.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/8/9 上午10:57
 **/
@EnableFeignClients
@SpringBootApplication
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }

    /**
     * 监听配置文件变化
     */
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return args ->{
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener("Order-config.yaml",
                    "DEFAULT_GROUP",
                    new Listener() {
                        @Override
                        public Executor getExecutor() {
                            return Executors.newFixedThreadPool(7);
                        }

                        @Override
                        public void receiveConfigInfo(String changeMsg) {
                            System.out.println("配置文件改变了：" + changeMsg);
                            //发送邮件
                        }
                    });
        };
    }
}
