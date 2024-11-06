package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T01_NotifyAndWait {
    volatile private List<Object> list = new ArrayList<>(10);

    public static void main(String[] args) {
        T01_NotifyAndWait t01_withoutVolatile = new T01_NotifyAndWait();
        final Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                System.out.println("t2 启动");
                System.out.println("size = " + t01_withoutVolatile.size());
                if (t01_withoutVolatile.size() != 5) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("t2 end");
                o.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            synchronized (o) {
                System.out.println();
                for (int i = 0; i < 10; i++) {
                    System.out.println("size()=" + t01_withoutVolatile.size());
                    if (t01_withoutVolatile.size() == 5) {
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("notify");
                    }
                    t01_withoutVolatile.add(i);
                    System.out.println("add value=" + i);

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }

    public void add(Object value) {
        if (value == null) {
            return;
        }

        list.add(value);
    }

    public int size() {
        return list.size();
    }
}
