package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.TimeUnit;

// 两个线程都可以访问，原因在哪里呢？
public class T2 {
    volatile Object o = new Object();

    public static void main(String[] args) {
        T2 t = new T2();
        //启动第一个线程
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //创建第二个线程
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object();//锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永 远得不到执行机会
        t2.start();
    }

    public void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(o.hashCode() + Thread.currentThread().getName());
            }
        }
    }
}
