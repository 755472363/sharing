package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM4 合并两个排序的链表
 */
public class Solution_BM4 {
    /**
     * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
     * 要求：空间复杂度 O(1)，时间复杂度 O(n)
     * <p>
     * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}
     * 输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}
     */

    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        ListNode headNode;
        ListNode curNode;
        if (list1.val == list2.val) {
            headNode = new ListNode(list1.val);
            curNode = headNode;
            curNode.next = new ListNode(list2.val);
            curNode = curNode.next;
        } else {
            if (list1.val > list2.val) {
                headNode = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                headNode = new ListNode(list1.val);
                list1 = list1.next;
            }
            curNode = headNode;
        }
        while (list1.next != null && list2.next != null) {
            if (list1.next.val == list2.next.val) {
                curNode.next = new ListNode(list1.next.val);
                curNode = curNode.next;
                curNode.next = new ListNode(list2.next.val);
                curNode = curNode.next;
                list1 = list1.next;
                list2 = list2.next;
                continue;
            }
            curNode.next = new ListNode(list1.next.val > list2.next.val ? list2.next.val : list1.next.val);
            curNode = curNode.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1.next == null) {
            while (list2.next != null) {
                curNode.next = new ListNode(list2.next.val);
                curNode = curNode.next;
                list2 = list2.next;
            }
        }
        if (list2.next == null) {
            while (list1.next != null) {
                curNode.next = new ListNode(list1.next.val);
                curNode = curNode.next;
                list1 = list1.next;
            }
        }
        return headNode;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list2.val > list1.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode headNode1 = new ListNode(1);
        ListNode headNode2 = new ListNode(2);
        ListNode curNode1 = headNode1;
        ListNode curNode2 = headNode2;

        for (int i = 3; i < 7; i++) {
            if (i % 2 == 0) {
                curNode2.next = new ListNode(i);
                curNode2 = curNode2.next;
            } else {
                curNode1.next = new ListNode(i);
                curNode1 = curNode1.next;
            }
        }
//        check(new Solution_BM4().Merge(headNode1, headNode1));
        check(new Solution_BM4().Merge(headNode1, headNode2));
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



