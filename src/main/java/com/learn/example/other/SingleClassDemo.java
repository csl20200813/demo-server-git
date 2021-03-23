package com.learn.example.other;


/**
 * @author: csl
 * @description:
 * @date: 2021-03-02 19:59
 */

public class SingleClassDemo {

    public SingleClassDemo() {
    }

    static class InterSingle {
        private static final SingleClassDemo instance = new SingleClassDemo();
    }

    public static SingleClassDemo get() {


        return InterSingle.instance;
    }


}

