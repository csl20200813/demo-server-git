package com.learn.example.util;

import com.learn.example.entity.User;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-07 23:26
 */

public class ConstantUtil {
    /**
     * 存放任务的队列
     */
    public static LinkedBlockingQueue<User> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
}