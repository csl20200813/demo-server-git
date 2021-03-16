package com.learn.example.controller;

import com.alibaba.fastjson.JSON;
import com.learn.example.entity.User;
import com.learn.example.service.impl.MySafeQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-05 22:28
 */
@RestController
public class MySafeQueueController {

    @Autowired
    MySafeQueueService mySafeQueueService;


    @PostMapping("addToQueue")
    public void addToQueue(@RequestBody String user) {
        mySafeQueueService.addToQueue(user);

    }


    @GetMapping("showQueueStatus")
    public void showQueueStatus() {
        mySafeQueueService.showQueueStatus();
    }


    @PostMapping("test")
    public void test(@RequestBody String user) {
        User userJson = JSON.parseObject(user, User.class);
        System.out.println(userJson);
    }

}