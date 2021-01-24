package com.learn.example.service.impl;

import com.learn.example.dao.CateTreeDao;
import com.learn.example.entity.CateTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateTreeServiceImpl {
    @Autowired
    CateTreeDao cateTreeDao;


    public List<CateTree> findAll() {
        return cateTreeDao.findAll();
    }

    public CateTree findById(String cid) {
        CateTree cateTree = new CateTree();
        Optional<CateTree> byId = cateTreeDao.findById(cid);
        if (byId.isPresent()) {
            cateTree = byId.get();
        }

        return cateTree;
    }
}
