package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.TreeSet;

/**
 * BM15 删除有序链表中重复的元素-I
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1 1 2,返回1 2
 * 给出的链表为1 1 2 3 3,返回1 2 3
 */
public class Solution_BM15_删除有序链表中重复的元素_1 {

    /**
     * 思路：用TreeSet，去重排序后，重新组成链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        TreeSet<Integer> set = new TreeSet<>();
        while (head != null) {
            set.add(head.val);
            head = head.next;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (Integer integer : set) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return dummyNode.next;
    }

    /**
     * 如何实现：空间复杂度O(1)
     * 思路：链表是有序的，可以使用快慢指针
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 针对最后重复的元素，设置为null
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode headm = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head1 = new ListNode(3);
        head.next = head2;
        head2.next = headm;
        headm.next = head3;
        head3.next = head1;

        check(head);
        ListNode res = new Solution_BM15_删除有序链表中重复的元素_1().deleteDuplicates2(head);
        check(res);
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



