package com.learn.example.entity;

import com.learn.example.exception.GenderException;

public class User implements Comparable<User> {
    String username;
    String passwd;
    Integer age;
    private String sex;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if ("man".equals(sex) || "woman".equals(sex)) {
            this.sex = sex;
        } else {
            try {
                throw new GenderException("请输入man or woman");
            } catch (GenderException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int compareTo(User s) {
        //return -1; //-1表示放在红黑树的左边,即逆序输出
        //return 1;  //1表示放在红黑树的右边，即顺序输出
        //return o;  //表示元素相同，仅存放第一个元素
        //主要条件 姓名的长度,如果姓名长度小的就放在左子树，否则放在右子树
        int num = this.username.length() - s.username.length();
        //姓名的长度相同，不代表内容相同,如果按字典顺序此 String 对象位于参数字符串之前，则比较结果为一个负整数。
        //如果按字典顺序此 String 对象位于参数字符串之后，则比较结果为一个正整数。
        //如果这两个字符串相等，则结果为 0
        int num1 = num == 0 ? this.username.compareTo(s.username) : num;
        //姓名的长度和内容相同，不代表年龄相同，所以还要判断年龄
        int num2 = num1 == 0 ? this.age - s.age : num1;
        return num2;
    }
}
