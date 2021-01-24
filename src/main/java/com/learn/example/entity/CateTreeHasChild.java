package com.learn.example.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author: csl
 * @description:
 * @date: 2021-01-24 18:34
 */
@Entity
@Table(name = "cate_tree")
public class CateTreeHasChild {

    @Column(name = "cate_name")
    private String cateName;
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String cid;

    @Column(name = "pid")
    private String pid;

    @Column(name = "modify_time")
    private Long modifyTime;

    @Transient
    private List<CateTreeHasChild> children;


    @Override
    public String toString() {
        return "CateTreeHasChild{" +
                "cateName='" + cateName + '\'' +
                ", cid='" + cid + '\'' +
                ", pid='" + pid + '\'' +
                ", modifyTime=" + modifyTime +
                ", children=" + children +
                '}';
    }

    public List<CateTreeHasChild> getChildren() {
        return children;
    }

    public void setChildren(List<CateTreeHasChild> children) {
        this.children = children;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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


}