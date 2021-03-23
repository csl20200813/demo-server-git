package com.learn.example.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.demo.entity.vo.UserVo;
import com.learn.example.entity.User;

import java.util.List;

/**
 *
 * @author pc
 */
public interface UserService extends IService<User> {

     void saveUser(User u);

     List<UserVo> findAllUserUseSql();

     void testUpdate(UserVo userVo);

}
