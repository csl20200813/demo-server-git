package com.learn.example.predicates.impl;

import com.learn.example.entity.User;
import com.learn.example.predicates.MyPredicate;

/**
 * @author: csl
 * @description:
 * @date: 2021-01-26 08:50
 */

public class FilterUserBySalaryImpl implements MyPredicate<User> {
    @Override
    public boolean test(User user) {
//        return user.getSalary() > 2000;
        return  false;
    }
}