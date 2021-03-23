package com.learn.example.demo;

import com.learn.example.service.impl.QueueService;
import com.learn.example.util.SpringUtils;
import org.junit.jupiter.api.Test;

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
