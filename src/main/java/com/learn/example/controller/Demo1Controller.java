package com.learn.example.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author: csl
 * @description:
 * @date: 2021-02-04 18:11
 */
@CrossOrigin
@RestController
public class Demo1Controller {

    @PostMapping("testPostList")
    public void testPostList(@RequestBody String data) {
        double aa = 121.2;
        System.out.println(data);
    }

    @GetMapping("testEx")
    public void testEx() {
        System.out.println("1212");
        int a = 10 / 0;
        System.out.println("哈哈哈");

    }


}


