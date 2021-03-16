package com.learn.example.entity;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-14 11:01
 */

public class DemoEntity {
    private static int a = 10;

    {
        System.out.println("普通代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public static void say() {

        {
            System.out.println("我哦我我");
        }
        System.out.println("哈哈哈");
    }

}