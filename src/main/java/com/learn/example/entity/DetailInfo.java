package com.learn.example.entity;

/**
 * @author pc
 */
public class DetailInfo {
    private Long code;
    private Long num;


    @Override
    public String toString() {
        return "DetailInfo{" +
                "code=" + code +
                ", num=" + num +
                '}';
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
