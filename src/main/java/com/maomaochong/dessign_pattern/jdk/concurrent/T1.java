package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.TimeUnit;

public class T1 {
    int count = 0;

    public static void main(String[] args) {
        T1 t1 = new T1();
        Runnable r = () -> t1.m();

        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r, "t2").start();
    }

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0; //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch,然后让循环继续
                System.out.println(i);
            }
        }
    }
}
