package com.learn.example.service.impl;

import com.learn.example.service.IBBService;
import org.springframework.stereotype.Service;

@Service
public class IBBServiceImpl implements IBBService {
    @Override
    public void doInBB(Integer abc) {
        System.out.println(abc);
    }

    @Override
    public void myAASay(String string) {

    }
}
