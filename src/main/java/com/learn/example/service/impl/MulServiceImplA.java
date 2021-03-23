package com.learn.example.service.impl;

import com.learn.example.service.MulService;
import org.springframework.stereotype.Service;

@Service
public class MulServiceImplA implements MulService {
    @Override
    public void showWho() {
        System.out.println("it is a");
    }
}
