package com.learn.example.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author csl
 */
@Component
@EnableScheduling
public class MyScheduleTask {
    /**
     * 下面的代码的功能是使得程序启动后就开始执行打印任务
     */
//    @Scheduled(fixedRate = 1000)
//    private void configureTask() {
//        System.out.println("你好" + System.currentTimeMillis());
//    }

}
