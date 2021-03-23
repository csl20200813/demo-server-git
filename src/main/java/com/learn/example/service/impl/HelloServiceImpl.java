package com.learn.example.service.impl;


import com.learn.example.entity.User;
import com.learn.example.service.HelloService;
import com.example.demo.thread.LockRunable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pc
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;


    @Override
    public String sayHello() {
        return "你好";
    }

    @Override
    public void save(User user) {
        System.out.println("service保存了：  " + user);
    }

    @Override
    public void testSyncInThread() {
        threadPoolExecutor.submit(new LockRunable(15));
        threadPoolExecutor.submit(new LockRunable(15));
        threadPoolExecutor.submit(new LockRunable(15));
        threadPoolExecutor.submit(new LockRunable(15));
        threadPoolExecutor.submit(new LockRunable(15));
    }
}
