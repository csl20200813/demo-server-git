package com.learn.example.controller;

import com.learn.example.runnable.GreetingRunnable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 向前台推送消息，主要目的是为了测试websocket
 */

@Controller
@ResponseBody
@CrossOrigin
public class GreetingController {


    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("triggerWebsocket")
    public boolean triggerWebsocket() throws InterruptedException {
        Runnable runnable = new GreetingRunnable(simpMessagingTemplate);
        Thread thread = new Thread(runnable);
        thread.start();
        return true;
    }


    @RequestMapping("testDie")
    public void helloSocket() {
        while (true){
            System.out.println(11   );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
