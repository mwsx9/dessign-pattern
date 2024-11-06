package com.maomaochong.dessign_pattern.jdk.concurrent.container;

public class T01_00_Question {
    public static void main(String[] args) {
        Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) ('A' + i));
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notifyAll();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 26; i++) {
                    System.out.print(i + 1);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notifyAll();
            }
        }, "t2").start();
    }
}
