package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.HashSet;

/**
 * BM10 两个链表的第一个公共结点
 */
public class Solution_BM10_两个链表的第一个公共结点 {


    // O(m*n)
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            ListNode temp = pHead2;
            while (temp != null) {
                if (set.contains(temp)) {
                    return temp;
                }
                temp = temp.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }

    // O(m+n)
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 解题思路：
     * 使用两个指针N1,N2，一个从链表1的头节点开始遍历，我们记为N1，一个从链表2的头节点开始遍历，我们记为N2。
     * 让N1和N2一起遍历，当N1先走完链表1的尽头（为null）的时候，则从链表2的头节点继续遍历，同样，如果N2先走完了链表2的尽头，则从链表1的头节点继续遍历，也就是说，N1和N2都会遍历链表1和链表2。
     * <p>
     * 因为两个指针，同样的速度，走完同样长度（链表1+链表2），不管两条链表有无相同节点，都能够到达同时到达终点。
     * （N1最后肯定能到达链表2的终点，N2肯定能到达链表1的终点）。
     * <p>
     * 所以，如何得到公共节点：
     * 有公共节点的时候，N1和N2必会相遇，因为长度一样嘛，速度也一定，必会走到相同的地方的，所以当两者相等的时候，则会第一个公共的节点
     * 无公共节点的时候，此时N1和N2则都会走到终点，那么他们此时都是null，所以也算是相等了。
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        while (n1 != n2) {
            if (n1 != null) {
                n1 = n1.next;
            } else {
                n1 = pHead2;
            }
            if (n2 != null) {
                n2 = n2.next;
            } else {
                n2 = pHead1;
            }
        }
        return n1;
    }

    /**
     * 简化写法
     */
    public ListNode FindFirstCommonNode4(ListNode pHead1, ListNode pHead2) {
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        while (n1 != n2) {
            n1 = (n1 != null) ? n1.next : pHead2;
            n2 = (n2 != null) ? n2.next : pHead1;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        ListNode pHead2 = new ListNode(2);
        ListNode headNode3 = new ListNode(3);
        ListNode headNode4 = new ListNode(4);
        ListNode headNode5 = new ListNode(5);

        pHead1.next = headNode3;
        pHead2.next = headNode4;
        headNode3.next = headNode5;
        headNode4.next = headNode5;

        check(pHead1);
        check(pHead2);
        ListNode res = new Solution_BM10_两个链表的第一个公共结点().FindFirstCommonNode4(pHead1, pHead2);
        System.out.println("两个链表的第一个公共结点 = " + res.val);

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



