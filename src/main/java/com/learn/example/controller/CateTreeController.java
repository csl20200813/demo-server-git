package com.learn.example.controller;

import com.learn.example.entity.CateTree;
import com.learn.example.entity.CateTreeHasChild;
import com.learn.example.service.impl.CateTreeHasChildServiceImpl;
import com.learn.example.service.impl.CateTreeServiceImpl;
import com.learn.example.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tree")
@CrossOrigin
public class CateTreeController {
    @Autowired
    CateTreeServiceImpl cateTreeService;

    @Autowired
    CateTreeHasChildServiceImpl cateTreeHasChildService;

    public void say111() {
        System.out.println("11111");
    }

    @GetMapping("myTree")
    public List<CateTreeHasChild> myTree() {
        List<CateTreeHasChild> cateList = cateTreeHasChildService.findAll();

        List<CateTreeHasChild> cateTreeHasChildren = TreeUtil.buildMenuTree(cateList, "0");
        System.out.println(cateList);
        System.out.println(cateTreeHasChildren);

        return cateTreeHasChildren;
    }


    @GetMapping("findAll")
    public List<Map<String, Object>> findAll() {
        List<CateTree> list = cateTreeService.findAll();
        System.out.println(list);


        System.out.println(TreeUtil.listToTree(list));

//        return cateTreeService.findAll();
        return TreeUtil.listToTree(list);
    }


    /**
     *
     * export function listToTree(treeData) {
     *     // result存储json数据转为树形结构后的结果
     *     // temp为临时对象，将json数据按照id值排序
     *     // len是json长度，用于循环遍历结束的条件
     *
     *     var result = []
     *     const temp = {}
     *     const len = treeData.length
     *     for (var i = 0; i < len; i++) {
     *       temp[treeData[i].cid] = treeData[i]
     *     }
     *     for (var j = 0; j < len; j++) {
     *       var currentElement = treeData[j]
     *       // 临时变量里面的当前元素的父元素，即pid的值，与找对应的id值
     *       var tempCurrentElementParent = temp[currentElement['pid']]
     *       // 如果有父元素，即如果有parentID属性
     *       if (tempCurrentElementParent) {
     *         if (!tempCurrentElementParent['children']) {
     *           tempCurrentElementParent['children'] = []
     *         }
     *         tempCurrentElementParent['children'].push(currentElement)
     *       } else {
     *         result.push(currentElement)
     *       }
     *     }
     *     return result
     *   }
     *
     */


    /**
     * 第一种，可行，但是最后一层children多了[] 不好
     *
     * @return
     */
    @GetMapping("handleOtherTree")
    public List<Map<String, Object>> findTree() {
        List<CateTree> cateList = cateTreeService.findAll();
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (CateTree cateTree : cateList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", cateTree.getCid());
            map.put("pid", cateTree.getPid());
            map.put("cateName", cateTree.getCateName());
            map.put("modifyTime", cateTree.getModifyTime());
            dataList.add(map);
        }

        List<Map<String, Object>> treeList = TreeUtil.doTreeList(dataList, "0");


        return treeList;
    }


}
