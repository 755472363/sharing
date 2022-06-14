package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * BM5_合并k个已排序的链表
 */
public class Solution_BM5_合并k个已排序的链表 {


    /**
     * 算法思想一：辅助数组
     * 解题思路
     * 主要采用将列表中的链表结点值遍历存储到辅助数组中，再对数组进行排序，根据排序后的数组元素一次构建新链表
     * 1、遍历列表，分别将每一个链表的元素值存储到数组tmp中
     * 2、对tmp进行排序
     * 3、依次遍历数组元素创新新链表
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }
        Collections.sort(list);

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        for (Integer integer : list) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }

        return dummyHead.next;
    }


    /**
     * 算法思想三：优先队列
     * 解题思路
     * 使用优先队列去存储所有链表。按照链表头结点值，进行从小到大的排序，最小的头结点的链表在堆顶。
     * 1、每次将堆顶的链表取出
     * 2、将头结点从取出的链表上去除，并插在所需目标链表的尾部。
     * 3、将取出的链表放回堆中。若链表为null，则不放回。
     * 重复1，2，3过程，直到堆为空，循环终止。
     */
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        for (ListNode listNode : lists) {
            while (listNode != null) {
                priorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (!priorityQueue.isEmpty()) {
            curr.next = new ListNode(priorityQueue.poll());
            curr = curr.next;
        }
        return dummyHead.next;
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
        ArrayList<ListNode> nodeList = new ArrayList<>();
        nodeList.add(headNode1);
        nodeList.add(headNode2);
        nodeList.add(headNode2);

        check(headNode1);
        check(headNode2);
        check(new Solution_BM5_合并k个已排序的链表().mergeKLists2(nodeList));
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



