package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.concurrent.locks.LockSupport;

public class T01_02_Question {
    private static Thread t2;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }

            LockSupport.unpark(t2);
        }, "t1");

        t1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print(i + 1);
                LockSupport.unpark(t1);
                LockSupport.park();
            }

            LockSupport.unpark(t1);
        }, "t2");

        t2.start();
    }
}
