package com.learn.example.demo;

import com.alibaba.fastjson.JSON;
import com.learn.example.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
