package com.learn.example.entity;



/**
 * @author csl
 */

//@Entity
//@Table(name = "cate_tree")
public class CateTree {


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    @Column(name = "cate_name")
    private String cateName;

//    @Id
//    @Column(name = "cid")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String cid;

//    @Column(name = "pid")
    private String pid;

//    @Column(name = "modify_time")
    private Long modifyTime;

 
    @Override
    public String toString() {
        return "CateTree{" +
                "cateName='" + cateName + '\'' +
                ", cid='" + cid + '\'' +
                ", pid='" + pid + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
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


