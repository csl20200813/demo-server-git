package com.learn.example.service.impl;

import com.learn.example.mapper.TreeMybatisDao;
import com.learn.example.entity.TreeMybatis;
import com.learn.example.service.TreeMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: csl
 * @description:
 * @date: 2021-03-16 09:46
 */
@Service
public class TreeMybatisSerivceImpl implements TreeMybatisService {


    @Autowired
    TreeMybatisDao treeMybatisDao;

    @Override
    public String test() {
        List<TreeMybatis> allTree = treeMybatisDao.findAllTree();
        System.out.println(allTree);
        return allTree.toString();
    }
}