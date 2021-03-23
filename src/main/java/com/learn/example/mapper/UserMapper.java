package com.learn.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.UserVo;
import com.learn.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pc
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查
     * @return
     */
    List<UserVo> findAllUserUseSql();

    /**
     * 修改
     * @param userVo
     */
    void testUpdate(UserVo userVo);
}
