package com.maomaochong.dessign_pattern.jdk;


/**
 * equal做比较；
 * 在hash型数据结构时，先比较hashcode，再比较equal。如果2个对象equal，但hashcode不同，hashMap会认为是2个对象。
 */
public class EqualsAndHashCodeTest {
    public static void main(String[] args) {
        String i = "s";
        String n = "s";
        String m = "ss";
        String x = "s";
        String y = "s";
        System.out.println(n == m);
        System.out.println(n == i);
        System.out.println(i.equals(n));
        System.out.println(x.equals(y));
        System.out.println(x == y);
    }
}
