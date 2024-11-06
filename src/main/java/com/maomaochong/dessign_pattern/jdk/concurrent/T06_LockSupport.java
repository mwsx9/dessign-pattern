package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class T06_LockSupport {
    static Thread t1 = null;
    volatile private List<Object> list = new ArrayList<>(10);

    public static void main(String[] args) {
        T06_LockSupport t06_lockSupport = new T06_LockSupport();

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            if (t06_lockSupport.size() != 5) {
                LockSupport.park();
            }

            System.out.println("t2 end");
            if (t1 != null) {
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("add value=" + i);
                t06_lockSupport.add(i);
                if (t06_lockSupport.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");

        t2.start();
        t1.start();
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
