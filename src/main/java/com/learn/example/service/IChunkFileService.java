package com.learn.example.service;

import com.learn.example.entity.Chunk;

import javax.servlet.http.HttpServletResponse;

public interface IChunkFileService {
    public String fileUploadPost(Chunk chunk, HttpServletResponse response);
}
