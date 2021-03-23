package com.learn.example.controller;


import com.learn.example.entity.Chunk;
import com.learn.example.service.impl.ChunkFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/bigFile")
@CrossOrigin
public class ChunkFileController {


    @Autowired
    ChunkFileServiceImpl chunkFileService;

    /**
     * 处理文件上传POST请求 1
     * 将上传的文件存放到服务器内
     *
     * @param chunk    文件块
     * @param response 响应
     * @return 上传响应状态
     */
    @PostMapping("fileUpload")
    public String uploadPost(@ModelAttribute Chunk chunk, HttpServletResponse response) {
        return chunkFileService.fileUploadPost(chunk, response);
    }
}
