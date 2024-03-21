package com.lihua.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lihua.service.ProviderService;


/**
 * @author liweihua
 * @classname ProviderServiceImpl
 * @description TODO
 * @date 2023/6/25 14:44
 */
//@Service将该类的对象创建出来，放到spring的ioc容器中 bean定义
//将这个类提供的方法（服务）对外发布，将访问的地址、ip、端口、路径注册到注册中心中  服务注册可用xml格式注册或者该注解注册
@Service(timeout = 3000,retries = 2,version = "2.0",weight = 111)//当前服务3秒超时，重试两次，一共三次,版本为2.0,负载均衡权重111
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String word) {
        return word;
    }
}
