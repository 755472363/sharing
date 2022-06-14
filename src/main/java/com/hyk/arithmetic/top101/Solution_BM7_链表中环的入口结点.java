package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.HashSet;

/**
 * BM7 链表中环的入口结点
 */
public class Solution_BM7_链表中环的入口结点 {


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headNode1 = new ListNode(1);
        ListNode headNode2 = new ListNode(2);
        ListNode headNode3 = new ListNode(3);
        ListNode headNode4 = new ListNode(4);
        ListNode headNode5 = new ListNode(5);

        headNode1.next = headNode2;
        headNode2.next = headNode3;
        headNode3.next = headNode4;
        headNode4.next = headNode5;
        headNode5.next = headNode3;
        System.out.println("链表中环的入口结点 = " + new Solution_BM7_链表中环的入口结点().EntryNodeOfLoop(headNode1).val);

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



