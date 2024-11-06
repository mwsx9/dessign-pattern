package com.maomaochong.dessign_pattern.jvm;

import java.util.concurrent.locks.LockSupport;

public class JavaHeapTest {
    public final static int OUTOFMEMORY = 200000000;
    StringBuffer tempOOM = new StringBuffer();
    private String oom;
    private int length;

    public JavaHeapTest(int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
        LockSupport.park();
    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

}
