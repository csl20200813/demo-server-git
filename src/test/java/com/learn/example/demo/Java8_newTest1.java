package com.learn.example.demo;

import com.learn.example.entity.CateTree;
import com.learn.example.entity.User;
import com.learn.example.predicates.MyPredicate;
import com.learn.example.predicates.impl.FilterUserByAgeImpl;
import com.learn.example.predicates.impl.FilterUserBySalaryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: csl
 * @description:
 * @date: 2021-01-26 08:30
 */

public class Java8_newTest1 {
    List<User> userList = Arrays.asList(
            new User("张三", 18, 1000),
            new User("李四", 38, 2000),
            new User("王五", 50, 3000),
            new User("赵柳", 16, 4000),
            new User("田七", 8, 10000)
    );

    /**
     * 优化方式1   策略设计模式
     */
    //1.对user按照MyPredicate的方式过滤
    public List<User> filterUser(List<User> users, MyPredicate<User> myPredicate) {
        List<User> resList = new ArrayList<>();

        for (User user : users) {
            if (myPredicate.test(user)) {
                resList.add(user);
            }
        }
        return resList;
    }

    /**
     * 优化方式1
     */
    @Test
    public void testFilter1() {
        List<User> users = filterUser(userList, new FilterUserByAgeImpl());
        List<User> users1 = filterUser(users, new FilterUserBySalaryImpl());
        for (User user : users1) {
            System.out.println(user);
        }
    }
    /**
     * ---------------------------------------------------------------------------------------------------
     */

    /**
     * 优化方式2
     */
    @Test
    public void testFilter2() {
        List<User> users = filterUser(userList, new MyPredicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getSalary() <= 3000 && user.getAge() < 50;
            }
        });

        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 优化方式3： 将优化2改为lambda表达式
     */
    @Test
    public void testFilter3() {
        List<User> users = filterUser(userList, (e) -> e.getSalary() <= 3000 && e.getAge() < 50);

        users.forEach(System.out::println);
    }


    /**
     * 优化方式4，上面的接口不用，只有数据源
     */
    @Test
    public void testFilter4() {
        userList.stream()
                .filter((e) -> e.getSalary() <= 3000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("---------------------------------");

        userList.stream()
                .map(User::getUsername)
                .forEach(System.out::println);
    }

}