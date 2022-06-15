package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.ArrayList;

/**
 * BM13 判断一个链表是否为回文结构
 */
public class Solution_BM13_判断一个链表是否为回文结构 {

    /**
     * 算法思想一：放到集合里，对撞指针判断，是否相同
     */
    public boolean isPail(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(l).equals(list.get(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }

    /**
     * 算法思想二：快慢指针，找到中点，反转半边，一一对比。
     */
    public boolean isPail2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        temp = reverse(temp);
        while (temp != null && head != null) {
            if (temp.val != head.val)
                return false;
            temp = temp.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        //前序节点
        ListNode prev = null;
        while (head != null) {
            //断开后序
            ListNode next = head.next;
            //指向前序
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode headm = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head1 = new ListNode(1);
        head.next = head2;
        head2.next = headm;
        headm.next = head3;
        head3.next = head1;

        check(head);
        boolean b = new Solution_BM13_判断一个链表是否为回文结构().isPail2(head);
        System.out.println("b = " + b);
//        {1,2},2
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



