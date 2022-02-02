package com.hyk.arithmetic;

import java.util.HashSet;
import java.util.Set;

public class Solution_NC4 {
    /**
     判断给定的链表中是否有环。如果有环则返回true，否则返回false。
     *
     *
     数据范围：链表长度 0 <= n <= 100000≤n≤10000，链表中任意节点的值满足 |val| <= 100000∣val∣<=100000
     要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     *
     输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。
     -1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。
     */

    /**
     * 一、是否有环，通过遍历所有节点的引用地址，放入set集合，是否重复
     * 疑问：如果可以存重复元素，就会有问题？ 不会，存的是节点的地址值
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 二、快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode curNode = headNode;

        for (int i = 1; i < 4; i++) {
            curNode.next = new ListNode(i + 1);
            curNode = curNode.next;
        }
        curNode.next = headNode;

//        check(headNode);
//        System.out.println("hasCycle1(headNode) = " + new Solution_NC4().hasCycle1(headNode));
        System.out.println("hasCycle2(headNode) = " + new Solution_NC4().hasCycle2(headNode));
//        check(headNode);
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



