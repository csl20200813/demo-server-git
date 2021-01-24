package com.learn.example.util;

import java.io.File;

/**
 * @author: csl
 * @description: 用于测试递归
 * @date: 2021-01-24 15:34
 */

public class FactorialUtil {


    public static void getAllFile(File dir) {
        System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFile(f);
            } else {
                System.out.println(f);
            }
        }
    }

    /**
     * 下面整个方法，递归次数太多了，会栈溢出
     *
     * @param i
     */
    public static void manytimes(int i) {
        System.out.println(i);
        if (i == 30000) {
            return;
        }
        manytimes(++i);
    }

    public static void writeStars2(int length) {
        if (length == 0) {
            // 基本情况
            System.out.println();
        } else {
            // 递归情况
            System.out.print("  *" + length);
            writeStars2(length - 1);
        }
    }


    /**
     * 结算阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    /**
     * 关于 递归中 递进和回归的理解
     */
    public static void recursion_display(int n) {
        //保证前后打印的值一样
        int temp = n;
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("回归:" + temp);
    }
}