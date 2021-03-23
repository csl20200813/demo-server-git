package com.learn.example.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * fdsf
 *
 * @author pc
 */
@RequestMapping("/api/openapi")
public interface OpenApiService {

    @RequestMapping(value = "/test")
    String testOpenApi();
}
