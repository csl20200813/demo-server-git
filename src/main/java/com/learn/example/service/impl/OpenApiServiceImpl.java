package com.learn.example.service.impl;

import com.learn.example.service.OpenApiService;

public class OpenApiServiceImpl implements OpenApiService {
    @Override
    public String testOpenApi() {
        System.out.println("openapi de shi xian lei fang fa ");
        return "hello";
    }
}
