package com.learn.example.service.impl;

import com.learn.example.entity.User;
import com.learn.example.util.ConstantUtil;


/**
 * @author: csl
 * @description:
 * @date: 2021-03-05 23:03
 */

public class MySingleThreadRunnable implements Runnable {
    @Override
    public void run() {
        while (!ConstantUtil.linkedBlockingQueue.isEmpty()) {
            try {
                User take = ConstantUtil.linkedBlockingQueue.take();
                System.out.println("取出了 " + take.getUsername());
                //延时，模拟任务会执行一会儿
                Thread.sleep(10 * 1000);
                System.out.println(take.getUsername() + " 执行完毕---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //这里的代码会执行很多次
    }
}