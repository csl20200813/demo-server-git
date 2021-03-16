package com.learn.example.entity;



/**
 * @author: csl
 * @description:
 * @date: 2021-03-16 09:42
 */


public class TreeMybatis {
    private String cid;

    private String cateName;

    private String pid;

    private Long modifyTime;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "TreeMybatis{" +
                "cid='" + cid + '\'' +
                ", cateName='" + cateName + '\'' +
                ", pid='" + pid + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}