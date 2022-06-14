package com.hyk.arithmetic.top101;

import com.hyk.arithmetic.ListNode;

public class Demo {

    public static void main(String[] args) {
        // 循环5次，生成12345链表，生成54321链表

        // 54321
        ListNode head1 = null;
        ListNode oldHead = null;
        for (int i = 1; i <= 5; i++) {
            head1 = new ListNode(i);
            head1.next = oldHead;
            oldHead = head1;
        }
        check(head1);

        // 12345 第一次头特殊处理（不推荐）
        ListNode head2 = null;
        ListNode currHead2 = null;
        for (int i = 1; i <= 5; i++) {
            if (head2 == null) {
                head2 = new ListNode(i);
                currHead2 = head2;
                continue;
            }
            currHead2.next = new ListNode(i);
            currHead2 = currHead2.next;
        }
        check(head2);

        // 12345 虚拟头节点（推荐）
        ListNode head3 = new ListNode(-1);
        ListNode curr = head3;
        for (int i = 1; i <= 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        check(head3.next);

    }


    private static void check(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode tempHead = head;
        while (tempHead != null) {
            sb.append(tempHead.val).append(" ");
            tempHead = tempHead.next;
        }
        System.out.println(sb.toString());
    }
}
