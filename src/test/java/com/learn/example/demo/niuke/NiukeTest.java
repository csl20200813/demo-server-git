package com.learn.example.demo.niuke;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-02 18:33
 */

public class NiukeTest {

    @Test
    void name() {
        String str = "abcd";
        char[] chars = str.toCharArray();
        String res = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i];
        }
        System.out.println(res);
    }

    @Test
    void fdf() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
    }
}