package com.maomaochong.dessign_pattern.nowcoder;

public class SolutionLinkedList02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd(node1, 2);
    }


    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        for (int i = 1; i <= n + 1; i++) {
            temp = temp.next;
        }

        ListNode target = head;
        while (temp != null) {
            temp = temp.next;
            target = target.next;
        }

        target.next = target.next.next;
        return head;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
