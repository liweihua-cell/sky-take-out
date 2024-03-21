package com.lihua.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lihua.service.ProviderService;


public class DubboController {

    /**
     * 1.从zookeeper注册中心获取providerService的访问url
     * 2.进行远程调用rpc
     * 3.将结果封装为一个代理对象，给变量赋值
     */
    @Reference(cluster = "failover",mock = "force:return:null")
    //远程注入,cluster为失败策略，其中failover为失败重试，failfast为快速失败，
    // failsafe为失败安全，failback为失败自动回复
    //mock为服务降级，force:return:null为强制降级且返回空值
    private ProviderService providerService;


    public String sayHello(){
        String str = "hello";
        return providerService.sayHello(str);
    }


}
