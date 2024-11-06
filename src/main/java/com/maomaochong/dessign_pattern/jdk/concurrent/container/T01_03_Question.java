package com.maomaochong.dessign_pattern.jdk.concurrent.container;

public class T01_03_Question {
    static volatile ReadyToRun r = ReadyToRun.T1;


    // 通过自旋锁来实现
    public static void main(String[] args) {
        // t1
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                while (r != ReadyToRun.T1) {
                }
                System.out.print((char) ('A' + i));
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        // t2
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                while (r != ReadyToRun.T2) {
                }

                System.out.print(i + 1);
                r = ReadyToRun.T1;
            }
        }, "t2").start();
    }

    enum ReadyToRun {T1, T2}
}
