package com.maomaochong.dessign_pattern.jdk;

import java.util.HashMap;
import java.util.Map;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 10;
        boolean b = i == j;
        System.out.println(b);

        Integer i1 = 1000;
        Integer j1 = 1000;
        boolean b1 = i1 == j1;
        System.out.println(b1);
    }

    // 下面这段代码说明，-128-127可以按照==进行判断，其他的不能，==是比较对象地址，由于-128-127是缓存的，所以可以按照地址比较，其他不行，因为每次都是new出来的。
    // 不过 缓存范围也可以设置。
//    public static Integer valueOf(int i) {
//        if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//            return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//        return new Integer(i);
//    }
}
