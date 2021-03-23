package com.learn.example.thread;

/**
 * @author csl
 */
public class ScheduledMyTestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程的runnable执行了..." + System.currentTimeMillis());
    }
}
