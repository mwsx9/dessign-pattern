package com.maomaochong.dessign_pattern.nowcoder;

public class Solution50 {

    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        // 递归
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
