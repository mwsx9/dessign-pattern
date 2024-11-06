package com.maomaochong.dessign_pattern.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> matchMap = new HashMap<>();
        matchMap.put(')', '(');
        matchMap.put(']', '[');
        matchMap.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (matchMap.containsKey(ch)) {
                char cur = stack.isEmpty() ? '#' : stack.pop();
                if (!matchMap.get(ch).equals(cur)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
