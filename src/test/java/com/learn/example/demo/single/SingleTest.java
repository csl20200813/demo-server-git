package com.learn.example.demo.single;

import com.learn.example.other.SingleClassDemo;
import com.learn.example.service.impl.RealDoor;
import org.junit.jupiter.api.Test;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-02 19:58
 */

public class SingleTest {

    @Test
    void sfdfsname() {
        RealDoor realDoor = new RealDoor();
        RealDoor realDoor1 = new RealDoor();
        System.out.println(realDoor);
        System.out.println(realDoor1);
    }


    @Test
    void fsdfsd() {
        SingleClassDemo singleClass1 = SingleClassDemo.get();
        SingleClassDemo singleClass2 = SingleClassDemo.get();
        System.out.println(singleClass1);
        System.out.println(singleClass2);
    }
}