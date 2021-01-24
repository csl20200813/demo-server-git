package com.learn.example.controller;

import com.learn.example.entity.CateTree;
import com.learn.example.service.impl.CateTreeServiceImpl;
import com.learn.example.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: csl
 * @description:学习递归
 * @date: 2021-01-24 14:49
 */
@RestController
@CrossOrigin
@RequestMapping("recursion")
public class RecursionLearnController {
    @Autowired
    CateTreeServiceImpl cateTreeService;

    @GetMapping("getList")
    public List<CateTree> getList() {
        List<CateTree> all = cateTreeService.findAll();
        System.out.println(all);
        return all;
    }


    /**
     * 找目录树
     */
    @GetMapping("findPath")
    public void findPath() {
        List<CateTree> all = cateTreeService.findAll();
        CateTree a22 = cateTreeService.findById("aabbcc33");

        List<String> resultList = new ArrayList<>();

        TreeUtil.treeFindParent(resultList, a22, all);

        System.out.println(resultList);
    }


}