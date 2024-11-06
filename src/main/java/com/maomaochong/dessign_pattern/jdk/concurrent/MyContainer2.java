package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
    private static Integer MAX = 10;
    private LinkedList<T> linkedList = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public static void main(String[] args) {
        MyContainer2<String> myContainer2 = new MyContainer2<>();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    myContainer2.put(Thread.currentThread().getName() + "_" + LocalDateTime.now());
                }
            }, "producer" + i).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "###" + myContainer2.get());
                }
            }, "consumer" + i).start();
        }
    }

    public void put(T t) {
        try {
            lock.lock();

            while (linkedList.size() == MAX) {
                consumer.signalAll();
                producer.await();
            }

            System.out.println("put value=" + t);
            linkedList.add(t);
            // consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (linkedList.size() == 0) {
                producer.signalAll();
                consumer.await();
            }

            t = linkedList.removeFirst();
            // producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return t;
    }
}
