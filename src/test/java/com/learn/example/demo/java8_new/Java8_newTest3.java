package com.learn.example.demo.java8_new;

import com.learn.example.predicates.CalNum;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: csl
 * @description: lambda 左侧： 接口的参数列表，右侧：接口的实现
 * @date: 2021-01-26 09:15
 */

/**
 * java8内置函数式接口
 * 方法引用
 */

public class Java8_newTest3 {
    @Test
    void name() {
        PrintStream out = System.out;
        System.out.println();
    }

    @Test
    void name1() {
        Supplier<String> sup = () -> "我是返回值";
        System.out.println(sup.get());

        Supplier<String> sup1 = () -> {
            return "我是返回值";
        };
    }
}
