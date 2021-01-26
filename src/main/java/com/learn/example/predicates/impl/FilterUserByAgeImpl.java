package com.learn.example.predicates.impl;

import com.learn.example.entity.User;
import com.learn.example.predicates.MyPredicate;

/**
 * @author: csl
 * @description:
 * @date: 2021-01-26 08:37
 */

public class FilterUserByAgeImpl implements MyPredicate<User> {
    @Override
    public boolean test(User user) {
        return user.getAge() >= 35;
    }
}