package com.maomaochong.dessign_pattern.nowcoder;

public class Solution24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        swapPairs(node1);
    }


    static public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head.next;
        ListNode temp = b == null ? a : b;

        ListNode pre = null;
        while (a != null && b != null) {
            if (pre != null)
                pre.next = b;
            a.next = b.next;
            b.next = a;

            pre = a;
            a = pre.next;
            if (a != null)
                b = pre.next.next;

        }

        return temp;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
