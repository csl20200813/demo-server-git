package com.learn.example.service.impl;

import com.learn.example.dao.CateTreeDao;
import com.learn.example.dao.CateTreeHasChildDao;
import com.learn.example.entity.CateTree;
import com.learn.example.entity.CateTreeHasChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateTreeHasChildServiceImpl {
    @Autowired
    CateTreeHasChildDao cateTreeHasChildDao;


    public List<CateTreeHasChild> findAll() {
        return cateTreeHasChildDao.findAll();
    }

    public CateTreeHasChild findById(String cid) {
        CateTreeHasChild cateTree = new CateTreeHasChild();
        Optional<CateTreeHasChild> byId = cateTreeHasChildDao.findById(cid);
        if (byId.isPresent()) {
            cateTree = byId.get();
        }

        return cateTree;
    }
}
