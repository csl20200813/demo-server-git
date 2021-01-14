package com.learn.example.service.impl;

import com.learn.example.dao.CateTreeDao;
import com.learn.example.entity.CateTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateTreeServiceImpl {
    @Autowired
    CateTreeDao cateTreeDao;


    public List<CateTree> findAll() {
        return cateTreeDao.findAll();
    }
}
