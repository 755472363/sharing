package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * BM12 单链表的排序
 */
public class Solution_BM12_单链表的排序 {

    /**
     * 算法思想一：辅助数组
     */
    public ListNode sortInList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (Integer integer : list) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return dummyNode.next;
    }

    /**
     * 算法思想二：归并排序（递归）
     */
    public ListNode sortInList2(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;
        // 使用快慢指针寻找链表的中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归左右两边进行排序
        ListNode left = sortInList2(head);
        ListNode right = sortInList2(tmp);
        // 创建新的链表
        ListNode h = new ListNode(0);
        ListNode res = h;
        // 合并 left right两个链表
        while (left != null && right != null) {
            // left  right链表循环对比
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 最后添加未对比的链表部分判断左链表是否为空
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        int i = 2;
        int k = 10;
        ListNode head = new ListNode(1);
        ListNode curr = head;
        while (i <= k) {
            curr.next = new ListNode(new Random().nextInt(10));
            curr = curr.next;
            i++;
        }
        check(head);
        ListNode newHead = new Solution_BM12_单链表的排序().sortInList(head);
        check(newHead);
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



