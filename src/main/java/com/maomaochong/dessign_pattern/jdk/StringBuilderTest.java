package com.maomaochong.dessign_pattern.jdk;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 100; i++) {
            sb.append(i);
            System.out.println(sb);
        }
    }
}
