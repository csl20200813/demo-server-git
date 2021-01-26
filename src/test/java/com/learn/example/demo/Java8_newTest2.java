package com.learn.example.demo;

import org.junit.jupiter.api.Test;

/**
 * @author: csl
 * @description: lambda 左侧： 接口的参数列表，右侧：接口的实现
 * @date: 2021-01-26 09:15
 */

/**
 * 语法格式：
 * 无参数，无返回值：
 */

public class Java8_newTest2 {
    @Test
    void test1() {
        //原来的写法
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("原来的run跑起来了");
            }
        };
        r.run();

        Runnable r1 = () -> System.out.println("hello  lambda！");
        r1.run();
    }
}