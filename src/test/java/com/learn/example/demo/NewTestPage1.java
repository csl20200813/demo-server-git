package com.learn.example.demo;

import com.learn.example.entity.User;
import org.junit.jupiter.api.Test;

public class NewTestPage1 {
    @Test
    void test1() {
        String ip = "200.200.180.110   ,  127.0.0.1";
        String[] ipList = ip.split(",");
        String resultIp = "";
        for (String s : ipList) {
            s = s.trim();
            if (!"127.0.0.1".equals(s)) {
                resultIp = s;
            }
            System.out.println(s);

        }
        System.out.println("结果是" + resultIp);
    }

    @Test
    void test2() {
        String ip = "200.200.180.123 ";
        String[] ipList = ip.split(",");
        for (String s : ipList) {
            System.out.println(s
            );
        }
    }


//    @Test
//    void testExc() {
//        User user = new User();
//        user.setUsername("王大锤");
//        user.setSex("辅导辅导");
//    }
}
