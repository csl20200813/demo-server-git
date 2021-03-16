package com.learn.example.mapper;

import com.learn.example.entity.TreeMybatis;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeMybatisDao {

    List<TreeMybatis> findAllTree();
}
