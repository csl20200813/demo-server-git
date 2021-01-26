package com.learn.example.demo;

import com.learn.example.predicates.CalNum;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author: csl
 * @description: lambda 左侧： 接口的参数列表，右侧：接口的实现
 * @date: 2021-01-26 09:15
 */

/**
 * 语法格式：
 */

public class Java8_newTest2 {

    /**
     * 无参数，无返回值
     */
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


    /**
     * 一个 参数，无返回值
     * 若只有一个参数，小括号可以不写
     */
    @Test
    void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我是consumer的入参");

        Consumer<String> con1 = x -> System.out.println(x);
        con1.accept("我是省略了小括号的");
    }

    /**
     * 有两个以上的参数，有返回值，并且lambda体中有多条语句
     */
    @Test
    void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口： " + x + "  " + y);
            return Integer.compare(x, y);
        };

        int res = com.compare(7, 22);
        System.out.println(res);
    }

    /**
     * 若lambda体只有一条语句，return和大括号都可以不写
     */
    @Test
    void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        int res = com.compare(7, 22);
        System.out.println(res);
    }


    /**
     * 函数式接口，对一个数进行计算
     * 求100的平方
     */
    @Test
    void test5() {
        Integer res = operation(100, x -> x * x);
        System.out.println(res);

    }

    public Integer operation(Integer n, CalNum<Integer> calNum) {
        return calNum.getVal(n);
    }

}
