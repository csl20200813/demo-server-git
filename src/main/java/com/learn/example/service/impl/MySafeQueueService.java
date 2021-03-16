package com.learn.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.learn.example.entity.User;
import com.learn.example.util.ConstantUtil;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-05 22:29
 */
@Service
public class MySafeQueueService {
    /**
     * 单线程，每次从队列任务中去一个任务执行
     */
    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    /**
     * 测试加入队列的方法
     *
     * @param user 用户
     */
    public void addToQueue(String user) {
        User userJson = JSON.parseObject(user, User.class);
        System.out.println("接收到  " + userJson.getUsername() + " 的请求，开始入队");

        try {
            //将任务添加到队列里面，我这里就添加一个对象进去测试
            //添加失败抛出异常
            ConstantUtil.linkedBlockingQueue.add(userJson);
        } catch (Exception e) {
            throw new RuntimeException("队列已满，请稍后在添加任务");
        }

        MySingleThreadRunnable runnable = new MySingleThreadRunnable();
        //Future<?> submit = singleThreadExecutor.submit(runnable);  可获得返回结果，有需要就用
        singleThreadExecutor.submit(runnable);

        System.out.println(userJson.getUsername() + "任务已经安排了，在异步进行处理了");
    }

    /**
     * 查看队列里面剩余的任务个数
     */
    public void showQueueStatus() {
        System.out.println(ConstantUtil.linkedBlockingQueue);
        Iterator<User> iterator = ConstantUtil.linkedBlockingQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}