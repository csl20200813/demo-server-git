package com.learn.example.demo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * @author: csl
 * @description:
 * @date: 2021-02-16 22:56
 */

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> System.out.println("啦啦啦"), Executors.newSingleThreadExecutor()).whenComplete((res, e) -> {
            System.out.println("结果是" + res + "    " + e);
        });
    }
}