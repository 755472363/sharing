package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * BM16 删除有序链表中重复的元素-II
 */
public class Solution_BM16_删除有序链表中重复的元素_2 {

    /**
     * 思路：用TreeMap计数，等于1的，重新组成链表
     * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
     * 例如：
     * 给出的链表为1 2 3 3 4 4 5, 返回1 2 5.
     * 给出的链表为1 1 1 2  3, 返回2 3.
     */
    public ListNode deleteDuplicates(ListNode head) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (head != null) {
            if (map.containsKey(head.val)) {
                map.put(head.val, map.get(head.val) + 1);
            } else {
                map.put(head.val, 1);
            }
            head = head.next;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                cur.next = new ListNode(integerIntegerEntry.getKey());
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 思路：
     * 这是一个升序链表，重复的节点都连在一起，我们就可以很轻易地比较到重复的节点，然后将所有的连续相同的节点都跳过，连接不相同的第一个节点。
     * //遇到相邻两个节点值相同
     * if(cur.next.val == cur.next.next.val){
     * int temp = cur.next.val;
     * //将所有相同的都跳过
     * while (cur.next != null && cur.next.val == temp)
     * cur.next = cur.next.next;
     * }
     * <p>
     * 具体做法：
     * step 1：给链表前加上表头，方便可能的话删除第一个节点。
     * step 2：遍历链表，每次比较相邻两个节点，如果遇到了两个相邻节点相同，则新开内循环将这一段所有的相同都遍历过去。
     * step 3：在step 2中这一连串相同的节点前的节点直接连上后续第一个不相同值的节点。
     * step 4：返回时去掉添加的表头。
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
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
        ListNode res = new Solution_BM16_删除有序链表中重复的元素_2().deleteDuplicates2(head);
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



