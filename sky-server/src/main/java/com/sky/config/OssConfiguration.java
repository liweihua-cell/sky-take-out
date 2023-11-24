package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**配置类用于创建AliOssUtil类
 * @author liweihua
 * @classname OssConfiguration
 * @description TODO
 * @date 2023/11/22 15:55
 */
@Configuration
@Slf4j
public class OssConfiguration {
    @Bean//程序启动时自动创建bean对象
    @ConditionalOnMissingBean//保证没有对应的bean时去创建一个bean对象
    public AliOssUtil aliOssUtil(AliOssProperties properties){
        log.info("开始创建阿里云上传工具类:{}",properties);
        return new AliOssUtil(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret(), properties.getBucketName());

    }
}
