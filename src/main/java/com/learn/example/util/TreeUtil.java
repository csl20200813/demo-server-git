package com.learn.example.util;


import com.learn.example.entity.CateTree;
import com.learn.example.entity.CateTreeHasChild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author csl
 */
public class TreeUtil {

    public static List<CateTreeHasChild> buildMenuTree(List<CateTreeHasChild> srcList, String pid) {
        List<CateTreeHasChild> treeList = new ArrayList<>();
        srcList.forEach(item -> {
//            if (StringUtils.equals(pid, item.getParentId())) {
            if (item.getPid().equals(pid)) {
                item.setChildren(buildMenuTree(srcList, item.getCid()));
                treeList.add(item);
            }
        });
        return treeList;
    }


    /**
     * 这个方法栈溢出了
     * @param resultList
     * @param srcList
     * @return
     */
    public static List<Map<String, Object>> myTreeLearn(List<Map<String, Object>> resultList, List<Map<String, Object>> srcList) {
        //list转树，"0"为根节点

        for (Map map : srcList) {
            if (map.get("pid").equals("0")) {
                //等于0 ，往数组里面存放
                resultList.add(map);
            } else {
                //不等于0，还不能存，先造数据
                //找到他的儿子
                for (Map<String, Object> stringObjectMap : srcList) {
                    if (stringObjectMap.get("pid").equals(map.get("cid"))) {
                        map.put("children", stringObjectMap);
                    }
                }
                myTreeLearn(resultList, srcList);
            }
        }

        return resultList;
    }


    /**
     * 传入一个id，找到整个目录树
     * pid = 0 为出口
     *
     * @param cateTree
     * @param cateTreeList
     * @return
     */
    public static void treeFindParent(List<String> resultList, CateTree cateTree, List<CateTree> cateTreeList) {
        for (CateTree tree : cateTreeList) {
            if (tree.getCid().equals(cateTree.getPid())) {
                resultList.add(tree.getCateName());
                if (!cateTree.getCid().equals("0")) {
                    treeFindParent(resultList, tree, cateTreeList);
                }
            }
        }
    }


    //递归tree树
    public static List<Map<String, Object>> doTreeList(List<Map<String, Object>> dataList, String pid) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (dataList != null) {
            for (Map<String, Object> item : dataList) {
                if (pid.equals(item.get("pid").toString())) {
                    List<Map<String, Object>> children = doTreeList(dataList, item.get("id").toString());
                    item.put("children", children);
                    resultList.add(item);
                }
            }
        }
        return resultList;
    }


    public static List<Map<String, Object>> listToTree(List<CateTree> srcList) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Map<String, Object>> srcMapList = new ArrayList<>();
        for (CateTree cateTree : srcList) {
            Map map = new HashMap();
            map.put("cid", cateTree.getCid());
            map.put("pid", cateTree.getPid());
            map.put("cateName", cateTree.getCateName());
            srcMapList.add(map);
        }


        Map<String, Map<String, Object>> tmpMap = new HashMap();
        int len = srcMapList.size();
        for (int i = 0; i < len; i++) {
            tmpMap.put((String) srcMapList.get(i).get("cid"), srcMapList.get(i));
        }

        Map<String, Object> currentElement = new HashMap<>();
        Map<String, Object> tempCurrentElementParent = new HashMap<>();


        for (int j = 0; j < len; j++) {
            currentElement = srcMapList.get(j);
            tempCurrentElementParent = tmpMap.get(currentElement.get("pid"));
            if (tempCurrentElementParent != null) {
                if (tempCurrentElementParent.get("children") == null) {
                    List<Map<String, String>> childrenList = new ArrayList<>();
                    tempCurrentElementParent.put("children", childrenList);
                }
//                tempCurrentElementParent.put("children", currentElement);
                ((List) tempCurrentElementParent.get("children")).add(currentElement);
            } else {
                resultList.add(currentElement);
            }
        }

        return resultList;
    }


//    public List<Map<String, Object>> listToTree(List<CateTree> srcList) {
//        List<Map<String, Object>> resultList = new ArrayList<>();
////        List<Map<String, Object>> tmpList = new ArrayList<>();
//        Map<String, Map<String, Object>> tmpMap = new HashMap();
//
//
//        Integer len = srcList.size();
//        for (Integer i = 0; i < len; i++) {
//
////            Map map = new HashMap();
////            map.put(srcList.get(i).getCid(), srcList.get(i));
////            tmpList.add(map);
//            tmpMap.put(srcList.get(i).getCid(), srcList.get(i));
//        }
//
//        for (int j = 0; j < len; j++) {
//            CateTree currentElement = srcList.get(j);
//            // 临时变量里面的当前元素的父元素，即pid的值，与找对应的id值
//            Map<String, Object> tempCurrentElementParent = tmpMap.get(currentElement.getPid());
//            // 如果有父元素，即如果有parentID属性
//            if (tempCurrentElementParent != null) {
//                if (tempCurrentElementParent.get("children") == null) {
//                    tempCurrentElementParent.put("children", new ArrayList<>());
//                }
//                tempCurrentElementParent.put("children", currentElement);
//            } else {
//                resultList.add(currentElement);
//            }
//        }
//        return resultList;
//    }
}
