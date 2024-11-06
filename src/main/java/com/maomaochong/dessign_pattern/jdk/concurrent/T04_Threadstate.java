package com.maomaochong.dessign_pattern.jdk.concurrent;

public class T04_Threadstate {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        System.out.println("after new:" + thread.getState());

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("after join:" + thread.getState());

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    // TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("--" + this.getState());
                System.out.println("A" + i);
            }
        }
    }
}
