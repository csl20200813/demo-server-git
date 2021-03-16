package com.learn.example.controller;

import com.learn.example.service.TreeMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-16 09:45
 */

@RestController
@RequestMapping("mybatis")
public class TreeMybatisController {
    @Resource
    TreeMybatisService treeMybatisService;


    @GetMapping("test")
    public String test() {
        String test = treeMybatisService.test();
        System.out.println(test);
        return test;
    }
}