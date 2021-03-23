package com.example.demo.thread;


/**
 * @author pc
 */
public class LockRunable implements Runnable {
    static final transient Object LOCK = new Object();

    int num;

    public LockRunable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (LOCK) {
            while (true) {
                if (num <= 0) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "    " + num--);
            }
        }
    }
}

