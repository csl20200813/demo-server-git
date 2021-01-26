package com.learn.example.demo;

import com.alibaba.fastjson.JSON;
import com.learn.example.entity.User;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DemoTest2 {

    @Test
    void fsdf() {
        User user1 = new User("张三", 12);
        User user2 = new User("李四", 45);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        System.out.println(list);
        System.out.println(list.toString());
        System.out.println(JSON.toJSON(list));
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    void fs1df() {
        Map map = new HashMap<>();
        map.put("key1", 111);
        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
    }

    @Test
    void fsdfsd() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    void fsfdsfdfsd() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
//        Integer::compare

        TreeSet<Integer> ts = new TreeSet<>(com);
    }


}
