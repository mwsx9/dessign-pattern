package com.maomaochong.dessign_pattern.jvm;

public class CLPreparation {
    public static final int INT_CONSTANT = 1000;
    public static final Integer INTEGER_CONSTANT = Integer.valueOf(10000);
    public static int a = 100;

    public static Object o = new Object();

    public static void main(String[] args) {
        synchronized (o) {
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
