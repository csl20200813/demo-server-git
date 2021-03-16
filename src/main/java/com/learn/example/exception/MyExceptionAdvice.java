package com.learn.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author: csl
 * @description:
 * @date: 2021-03-09 23:11
 */
@Slf4j
//@RestControllerAdvice(basePackages = "com.learn.example.controller")
@RestControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String handleValidException(Exception e) {
        System.out.println("统一异常触发了");
        System.out.println("异常原因是：   " + e.getMessage());
        e.printStackTrace();
        return e.getMessage();

    }

}