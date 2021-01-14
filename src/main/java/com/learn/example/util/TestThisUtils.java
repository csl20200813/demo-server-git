package com.learn.example.util;

public class TestThisUtils {
    public TestThisUtils A() {
        System.out.println("A");
        System.out.println(this);
        return this;
    }

    public TestThisUtils B() {
        System.out.println("B");
        System.out.println(this);
        return this;
    }
}
