package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class T09_TransferQueue {
    public static void main(String[] args) {
        TransferQueue<String> strs = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        try {
            strs.transfer("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //strs.put("aaa");
      /*new Thread(() -> {
         try {
            System.out.println(strs.take());
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }).start();*/
    }

}
