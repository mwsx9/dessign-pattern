package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.Vector;

public class TicketSeller2 {

    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("ticketNo_" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // tickets.remove(0);
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }, "t" + i).start();
        }
    }
}
