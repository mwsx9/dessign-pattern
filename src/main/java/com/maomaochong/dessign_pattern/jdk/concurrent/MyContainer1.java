package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class MyContainer1<T> {
    final private int MAX = 10; //最多10个元素
    private LinkedList<T> list = new LinkedList();

    public static void main(String[] args) {
        MyContainer1<String> myContainer1 = new MyContainer1<>();

        // 生产者
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    myContainer1.put(Thread.currentThread().getName() + "_" + LocalDateTime.now());
                }
            }, "producer" + i).start();
        }

        // 消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String string = myContainer1.get();
                    System.out.println(Thread.currentThread().getName() + "###" + string);
                }
            }, "consumer" + i).start();
        }
    }

    synchronized public void put(T t) {
        while (list.size() >= MAX) { // 用if 在wait之后 还可能是满的
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("put value=" + t);
        list.add(t);
        this.notifyAll();
    }

    synchronized public T get() {
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t = list.removeFirst();
        this.notifyAll();
        return t;
    }

    synchronized public int getCount() {
        return list.size();
    }
}
