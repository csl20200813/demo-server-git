//package com.learn.example.controller;
//
//import com.learn.example.runnable.ScheduledMyTestRunnable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.scheduling.support.ScheduledMethodRunnable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @author csl
// */
//@RestController
//public class DynamicScheduledTask {
//    private static String DEFAULT_CRON = "0/1 * * * * ?";
//
//    private ScheduledFuture<?> future;
//    @Resource
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        return new ThreadPoolTaskScheduler();
//    }
//
//    @GetMapping("startTask")
//    public String startTask() {
//        future = threadPoolTaskScheduler.schedule(new ScheduledMyTestRunnable(), new CronTrigger(DEFAULT_CRON));
//        System.out.println("controller里面任务已经安排了");
//        return "controller is ok";
//    }
//
//    @GetMapping("stopTask")
//    public String stopTask() {
//        if (future != null) {
//            future.cancel(true);
//        }
//
//        System.out.println("controller里面手动停止了任务");
//        return "controller command to stop";
//    }
//}
