package com.learn.example.service;


import com.learn.example.entity.User;

public interface HelloService {
    /**
     * say
     * @return
     */
    String sayHello();

    void save(User user);

    void testSyncInThread();

}
