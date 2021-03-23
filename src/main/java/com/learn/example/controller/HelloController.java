package com.learn.example.controller;

import com.learn.example.entity.User;
import com.learn.example.service.HelloService;
import com.learn.example.service.MulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author pc
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @Qualifier("mulServiceImplB")
    @Autowired
    MulService mulService;


    @GetMapping("mulService")
    public void mulService() {
        mulService.showWho();
    }


    @GetMapping("sayHello")
    public String sayHello() {
        String s = helloService.sayHello();
        System.out.println(s);
        return s;
    }


    @PostMapping("save")
    public void save(@RequestBody User user) {

//        helloService.save(user);
    }


    @GetMapping("testSession")
    public void testSession(HttpServletResponse response, HttpSession session) throws IOException {
        session.setAttribute("myyysession", "11111");
        Cookie cookie = new Cookie("mycooki", "23232");
        response.addCookie(cookie);
        ServletOutputStream sos = response.getOutputStream();
        sos.flush();
        sos.close();
    }

    @GetMapping("testSync")
    public synchronized String testSync() throws Exception {
        System.out.println("你好" + Thread.currentThread().getName().toString());
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("-----");
                Thread.sleep(1000);
            }
        }
        System.out.println("再见" + Thread.currentThread().getName().toString());
        return "这是  " + Thread.currentThread().getName().toString();
    }

    @GetMapping("testSyncInThread")
    public void testSyncInThread() {
        helloService.testSyncInThread();
    }

}
