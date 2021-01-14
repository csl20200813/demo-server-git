package com.learn.example.dao;

import com.learn.example.entity.CateTree;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author csl
 */
public interface CateTreeDao extends JpaRepository<CateTree, String> {

}
