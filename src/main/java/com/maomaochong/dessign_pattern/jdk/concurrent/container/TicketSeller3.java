package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.LinkedList;
import java.util.List;

public class TicketSeller3 {

    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("ticketNo_" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) {
                            break;
                        }

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // tickets.remove(0);
                        System.out.println("销售了--" + tickets.remove(0));
                    }
                }
            }, "t" + i).start();
        }
    }
}
