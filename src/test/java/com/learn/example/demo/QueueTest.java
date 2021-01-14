package com.learn.example.demo;

import com.learn.example.service.QueueService;
import com.learn.example.util.SpringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QueueTest {

//    @Autowired
//    QueueService myqueueService;
//

    //    QueueService queueService = new QueueService();
    @Test
    public void say() {
//        queueService.test1();


        QueueService bean = (QueueService) SpringUtils.getBean("QueueService",QueueService.class);
        bean.test1();

    }
}
