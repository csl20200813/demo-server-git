package com.learn.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.demo.entity.vo.UserVo;

import com.learn.example.entity.User;
import com.learn.example.mapper.UserMapper;
import com.learn.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void saveUser(User u) {
        this.save(u);
    }

    @Override
    public  List<UserVo> testMybatis() {
        //List<User> users = baseMapper.selectList(null);
        List<UserVo> userVos = userMapper.testMybatis();
        System.out.println(userVos);
        return userVos;
    }

    @Override
    public void testUpdate(UserVo userVo) {
        userMapper.testUpdate(userVo);
    }
}
