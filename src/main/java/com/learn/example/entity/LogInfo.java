package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author pc
 */
@TableName("log_info")
public class LogInfo implements Serializable {
    private static final long serialVersionUID = 7925874058046995566L;


    private String id;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 操作时间
     */
    @TableField(value = "create_time")
    private String createTime;

    @Override
    public String toString() {
        return "LogInfo{" +
                "id='" + id + '\'' +
                ", operation='" + operation + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
