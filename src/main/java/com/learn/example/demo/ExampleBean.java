package com.learn.example.demo;

import com.learn.example.entity.User;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExampleBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }


    public static void main1(String[] args) {

    }


    public void test() {
        System.out.println("Hello World");
    }


    public static void main(String[] args) {
//        TreeSet<User> ts = new TreeSet<User>();
//        Set<User> ts = new HashSet<>();
        TreeSet<User> ts = new TreeSet<User>();
        //创建元素对象
        User s1 = new User("zhangsan", 20);
        User s2 = new User("lis", 22);
        User s3 = new User("wangwu", 24);
        User s4 = new User("chenliu", 26);
        User s5 = new User("zhangsan", 22);
        User s6 = new User("qianqi", 24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);

        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for (User s : ts) {
            System.out.println(s.getUsername() + "-----------" + s.getAge());
        }
    }


}
