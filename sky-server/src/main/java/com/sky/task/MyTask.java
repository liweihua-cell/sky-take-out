package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 自定义定时任务类
 *
 * @author liweihua
 * @classname MyTask
 * @description TODO
 * @date 2023/11/27 16:22
 */
@Component
@Slf4j
public class MyTask {

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void execute(){
//        log.info("定时任务开始执行:{}", LocalDateTime.now());
//    }
}
