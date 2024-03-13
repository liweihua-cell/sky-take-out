package com.sky.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sky.entity.AddressBook;
import com.sky.service.impl.AddressBookServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
//@FeignClient(value = "sky-takeout",fallback = AddressBookServiceImpl.class)
// 添加@FeignClient实现微服务调用，value为指定调用nacos下哪个微服务,fallback为服务降级返回的数据或抛出的异常

public interface AddressBookService {
    //@PostMapping("/api/addbook")      @FeignClient+@PostMapping("/api/addbook")就是一个完整的请求路径 http://sky-takeout/api/addbook
    List<AddressBook> list(AddressBook addressBook);


    void save(AddressBook addressBook);

    AddressBook getById(Long id);

    void update(AddressBook addressBook);

    void setDefault(AddressBook addressBook);

    void deleteById(Long id);



}
