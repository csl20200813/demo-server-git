package com.learn.example.demo;

import com.learn.example.entity.User;
import com.learn.example.service.IAAService;
import com.learn.example.runnable.ThreadSleepRunnable;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTest1 {

    @Test
    public void test() {
        //测试图片路径裁剪
        String str = "\\storage\\95534\\a1398473298473219847193";
//        String imgName = str.substring(str.lastIndexOf(File.separator) + 2);
        String imgName = str.substring(9);
        System.out.println(imgName);
    }

    @Test
    public void test342432() {
        String src = "成都,北京";
        String[] list = src.split(",");
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void tets21212() {
        String regex = "&lt;TF_title_1&gt;(.*?)&lt;/TF_title_1&gt;";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("11");
        while (matcher.find()) {
            System.out.println("group是：" + matcher.group());
        }
    }

    @Test
    public void tet222s21212() {
        User user = new User();
        Method[] methods = User.class.getMethods();

        System.out.println(methods);
        for (Method method : methods) {
            System.out.println("--------------------------------------");
            System.out.println(method);
            System.out.println(method.getName());
            System.out.println(method.getAnnotatedReturnType());
            System.out.println(method.getClass());
        }
    }


    @Test
    public void tet2fs22s21212() {
        System.out.println(User.class.isAnnotation());
        System.out.println(IAAService.class.isInterface());
    }


    @Test
    public void tetfdf222s21212() {
        User u1 = new User();
        User u2 = new User();
        System.out.println(u1 == u2);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u1.equals(u2));
    }


    @Test
    public void testfsdf() {
        Map<String, Object> map = new HashMap();
        map.put("k1ey1", 111);
        map.put("key2", true);
        map.put("key3", "fdfd");


        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    @Test
    public void testThread() throws InterruptedException {
        Runnable r1 = new ThreadSleepRunnable();
        Thread thread = new Thread(r1);
        thread.start();
//        while (true){}

//        thread.join();
//        Thread.sleep(3000);
    }


    @Test
    void tetsfd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("测试" + i);
        }
        System.out.println(sb);
        System.out.println(sb.toString());
    }
}
