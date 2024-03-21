package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
//@EnableDiscoveryClient 配置在启动类上实现springcloud服务的注册
//有关springcloud的具体代码案例参考AddressBookServiceImpl类
//有关feign的远程调用的具体代码参考AddressBookService接口
//sentinel相关的限流配置参考FilterContextConfig类,异常处理配置参考AddressBookServiceImpl类，规则持久化配置参考FilePersistence类
//gateway部分请看api-gateway模块
@EnableFeignClients//开启feign
@EnableScheduling//开启任务调度
public class SkyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyApplication.class, args);
        log.info("server started");
    }
}
