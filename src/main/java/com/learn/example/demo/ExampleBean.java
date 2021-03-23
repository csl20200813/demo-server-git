package com.learn.example.demo;

import org.springframework.beans.factory.InitializingBean;


public class ExampleBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }


    public static void main1(String[] args) {

    }


    public void test() {
        System.out.println("Hello World");
    }


}
