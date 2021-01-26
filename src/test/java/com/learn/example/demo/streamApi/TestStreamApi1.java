package com.learn.example.demo.streamApi;

import com.learn.example.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: csl
 * @description:. stream操作的三个步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 * @date: 2021-01-27 00:40
 */

public class TestStreamApi1 {
    List<User> userList = Arrays.asList(
            new User("张三", 18, 1000),
            new User("李四", 38, 2000),
            new User("王五", 50, 3000),
            new User("赵柳", 16, 4000),
            new User("田七", 8, 10000)
    );

    /**
     * 创建流
     */
    @Test
    void name() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
//        stream.
        Stream<String> stringStream = list.parallelStream();
//        stringStream.forEach();


        User[] users = new User[10];
//        users.
        Stream<User> stream1 = Arrays.stream(users);

        Stream<User> users1 = Stream.of(users);
//        users1.
    }


    /**
     * 终止流
     */
    @Test
    void name1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream = list.stream();
        //   stream.forEach(System.out::println);   下面的和这句话等同，方法引用
        stream.forEach(System.out::println);

    }


    /**
     * 筛选切片
     */
    @Test
    void name3() {
        Stream<User> userStream = userList.stream()
                .filter(e -> {
                    System.out.println("中间操作执行了");
                    return e.getAge() >= 18;
                })
                .limit(12);
        userStream.forEach(System.out::println);


    }
}