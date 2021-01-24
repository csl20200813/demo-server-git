package com.learn.example.dao;

import com.learn.example.entity.CateTree;
import com.learn.example.entity.CateTreeHasChild;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author csl
 */
public interface CateTreeHasChildDao extends JpaRepository<CateTreeHasChild, String> {

}
