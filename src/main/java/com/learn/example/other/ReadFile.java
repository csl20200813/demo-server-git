package com.learn.example.other;

public class ReadFile {

    public static void main(String[] args) {
        String path = ReadFile.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);
    }
}
