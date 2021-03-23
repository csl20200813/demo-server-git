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

    @GetMapping("list")
    public List<User> list() {
//        return userService.list();
        return null;
    }

    @PostMapping("save")
    public void save(@RequestBody User user) {
//        userService.save(user);
    }


    @GetMapping("testMybatis")
    public List<UserVo> testMybatis() {
        return userService.testMybatis();
    }

    @PostMapping("/testUpdate")
    public void testUpdate(@RequestBody UserVo userVo){
        userService.testUpdate(userVo);
    }
}
