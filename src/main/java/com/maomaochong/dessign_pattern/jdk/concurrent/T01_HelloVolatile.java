package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
    volatile boolean running = true;

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
        System.out.println(t.running);
    }

    void m() {
        System.out.println("m start");
        while (running) {
            // System.out.println("running");
        }
        System.out.println("m end!");
    }
}
