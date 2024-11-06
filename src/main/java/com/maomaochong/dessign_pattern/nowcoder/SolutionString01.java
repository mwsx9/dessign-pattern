package com.maomaochong.dessign_pattern.nowcoder;

public class SolutionString01 {
    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        reverseString(chars);
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;

            i++;
            j--;
        }
    }
}
