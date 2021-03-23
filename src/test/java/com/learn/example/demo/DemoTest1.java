package com.learn.example.demo;

import com.learn.example.controller.CateTreeController;
import com.learn.example.entity.DemoEntity;
import com.learn.example.entity.User;
import com.learn.example.service.IAAService;
import com.learn.example.thread.ThreadSleepRunnable;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
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
    void fdsfs() {
        System.out.println(getNum(3));

    }

    private int getNum(int i) {
        int res = 0;
        switch (i) {
            case 1:
                res = res + i;
            case 3:
                res = res + i * 2;
            case 5:
                res = res + i * 3;
            case 6:
                res = res + 2;

        }
        return res;
    }


    @Test
    void fsdfsdf() {
//        String str1 = "world";
//        String str2 = "wo" + "rld";
//        String str3 = "wo" + new String("rld");
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str3 == str2);

        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = "hello" + "world";
        System.out.println(s3 == s4);
        System.out.println(s3 == s1 + s2);// false   s1+s2先开空间再拼接。
        System.out.println(s3.equals((s1 + s2)));// true

        System.out.println(s3 == "hello" + "world");// true
        System.out.println(s3.equals("hello" + "world"));// true

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


    @Test
    void fsdf() {
        int[] ints = {12, 2, 34, 4, 55, 6, 3434};
        for (int anInt : ints) {
            System.out.println(anInt);
        }

//      ints.
    }

    public static void main1(String[] args) {
        Integer score = 98;
        System.out.println(getLevel(score));
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        Map map = new HashMap();
        Map<Object, Object> mymap = Collections.synchronizedMap(map);
//        mymap.

    }

    public static String getLevel(Integer score) {
        if (score > 100 || score < 0) {
            return "参数错误";
        }

        if (score >= 90) {
            return "A";
        }

        if (score < 60) {
            return "C";
        }

        return "B";
    }

    @Test
    void sdfsdfdsf() {
        try {
            String[] strs = new String[5];
            System.out.println(strs[5]);
            return;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println("abcd");
        }
    }

    @Test
    void dfdffd() {
        String str = "1234";
        changeStr(str);
        System.out.println(str);
    }

    public static void changeStr(String str) {
        str = "welcome";
    }

    public static void ma1in(String[] args) {


        //        Integer sum = 0;
//        for (int i = 1; i <= 10; i++) {
//            sum += rec(i);
//        }
//        System.out.println(sum);

        String abc = "hello world";
        char[] chars = abc.toCharArray();

        String ret = "";

        StringBuffer str = new StringBuffer("abcd");
//        str.
        StringBuffer reverse = str.reverse();
        System.out.println(reverse);


        for (int i = chars.length - 1; i >= 0; i--) {
            ret += chars[i];
        }
        System.out.println(ret);

    }

    public static Integer rec(Integer num) {
        if (num == 1) {
            return num;
        } else {
            return num * rec(num - 1);
        }
    }

    @Test
    void fsdfssdfsdfdf() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        User user1 = new User("张三", "123");
//        User user2 = new User("张三", "123");
//        System.out.println(user1.equals(user2));


//        RealDoor realDoor = new RealDoor();
//        realDoor.createDoor();

        Class<?> aClass = Class.forName("com.learn.example.entity.DemoEntity");
        System.out.println(aClass.getName());

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass1 = systemClassLoader.loadClass("com.learn.example.entity.DemoEntity");
        System.out.println(aClass1.getName());
        Object instance = aClass1.newInstance();
        DemoEntity demoEntity = (DemoEntity) instance;
        System.out.println(instance);
        System.out.println(demoEntity);
        LinkedList<Integer> integers = new LinkedList<>();

        ArrayBlockingQueue<Integer> integers1 = new ArrayBlockingQueue<Integer>(10);
        LinkedBlockingQueue<Integer> integers2 = new LinkedBlockingQueue<>();
        PriorityBlockingQueue<Integer> integers3 = new PriorityBlockingQueue<>(10);

    }


    @Test
    void sdfsdfsdf() throws ClassNotFoundException {
//        DemoEntity demoEntity = new DemoEntity();
//        System.out.println(demoEntity);

        DemoEntity.say();
    }


    @Test
    void fdsfsdfsss() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method say111 = CateTreeController.class.getDeclaredMethod("say111");
        say111.invoke(new CateTreeController());
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        ReentrantLock lock = new ReentrantLock();

        List<Integer> list1 = new ArrayList<>();

        Integer aa = 112;

    }
}




