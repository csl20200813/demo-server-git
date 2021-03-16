package com.learn.example.demo.thread;

import java.util.concurrent.*;

/**
 * @author: csl
 * @description:
 * @date: 2021-02-16 17:13
 */

public class ThreadTest {

    public static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread01 thread01 = new Thread01();
//        thread01.run();
//        FutureTask<Integer> futureTask = new FutureTask<>(new Call01());
////        Thread thread = new Thread(futureTask);
////        thread.start();
////
////        System.out.println("主线程继续执行");
////        Integer integer = futureTask.get();
////        System.out.println("执行结果是：" + integer);



        System.out.println("主线程开始");
        service.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程池的runnable执行了");
        });
        System.out.println("主线程结束");

    }


    public static class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行了");
            System.out.println("继承啦啦啦啦");
        }
    }


    public static class Call01 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "执行了");
            Thread.sleep(2000);
            System.out.println("call啦啦啦啦");

            return 123;
        }
    }
}