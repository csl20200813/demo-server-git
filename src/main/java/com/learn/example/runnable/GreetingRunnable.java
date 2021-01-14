package com.learn.example.runnable;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.HashMap;
import java.util.Map;

public class GreetingRunnable implements Runnable {

    private SimpMessagingTemplate simpMessagingTemplate;

    public GreetingRunnable(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Map map = new HashMap<>();
            map.put("key", "notifySuccess");
            map.put("title", "我是从服务端websocket第" + (i + 1) + "次返回的消息");
            simpMessagingTemplate.convertAndSend("/topic/websocketInfo/" + "csl", map);
//            simpMessagingTemplate.
        }
    }
}
