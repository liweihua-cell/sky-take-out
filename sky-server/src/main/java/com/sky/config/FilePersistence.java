package com.sky.config;

import com.alibaba.csp.sentinel.init.InitFunc;
import org.springframework.beans.factory.annotation.Value;


public class FilePersistence implements InitFunc {

    @Value("spring.application.name")

    @Override
    public void init() throws Exception {
        //具体代码没找到，后续再补充

    }
}
