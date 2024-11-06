package com.maomaochong.dessign_pattern.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocationTest {
    private static int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        // -Xmx20M -Xms20M
        try {
            testAllocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 对象优先在Eden分配
    public static void testAllocation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        byte[] allocation1 = new byte[2 * _1MB];
        System.out.println("输入字符：");
        reader.readLine();

        byte[] allocation2 = new byte[2 * _1MB];
        System.out.println("输入字符：");
        reader.readLine();

        byte[] allocation3 = new byte[2 * _1MB];
        System.out.println("输入字符：");
        reader.readLine();

        byte[] allocation4 = new byte[4 * _1MB];
        System.out.println("输入字符：");
        reader.readLine();
    }
}
