package com.learn.example.controller;

import com.example.demo.entity.vo.UserVo;
import com.learn.example.entity.User;
import com.learn.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pc
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 通过mybatis-plus查所有的用户
     *
     * @return
     */
    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }

    /**
     * 通过mybatis的sql语句查询所有的用户
     *
     * @return List<UserVo>
     */
    @GetMapping("findAllUserUseSql")
    public List<UserVo> findAllUserUseSql() {
        return userService.findAllUserUseSql();
    }

    @PostMapping("save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }


    @PostMapping("/testUpdate")
    public void testUpdate(@RequestBody UserVo userVo) {
        userService.testUpdate(userVo);
    }
}
