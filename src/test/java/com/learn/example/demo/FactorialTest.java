package com.learn.example.demo;

import com.learn.example.util.FactorialUtil;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author: csl
 * @description:
 * @date: 2021-01-24 15:31
 */

public class FactorialTest {


    /**
     * 计算阶乘
     */
    @Test
    public void factorial() {

        System.out.println(FactorialUtil.factorial(2));
    }

    @Test
    public void factorial1() {
        try {
            Process exec = Runtime.getRuntime().exec("netstat -nao");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void recursion_display() {
        FactorialUtil.recursion_display(12);
    }

    @Test
    public void writeStars2() {
        FactorialUtil.writeStars2(12);
    }

    /**
     * 下面整个方法，递归次数太多了，会栈溢出
     *
     * @param
     */
    @Test
    public void manytimes() {
        FactorialUtil.manytimes(12);
    }

    //打印被遍历的目录名称
    @Test
    public void getAllFile() {
        File file = new File("D:\\BaiduNetdiskDownload");
        FactorialUtil.getAllFile(file);
    }
}
