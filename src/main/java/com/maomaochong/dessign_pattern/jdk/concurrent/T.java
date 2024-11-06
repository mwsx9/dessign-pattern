package com.maomaochong.dessign_pattern.jdk.concurrent;


import java.util.concurrent.TimeUnit;

/**
 * synchronized是可重入锁
 */
public class T {
    public static void main(String[] args) {
        new T().m1();
        new TT().m2();
    }

    synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    static class TT extends T {
        @Override
        synchronized void m2() {
            System.out.println("child m start");
            super.m2();
            System.out.println("child m end");
        }
    }
}
