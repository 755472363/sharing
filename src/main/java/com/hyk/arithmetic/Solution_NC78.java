package com.hyk.arithmetic;

import java.util.Stack;

/**
 * NC78 反转链表
 */
public class Solution_NC78 {
    /**
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
     *
     * 数据范围： n\leq1000n≤1000
     * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
     *
     * 如当输入链表{1,2,3}时，
     * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
     *
     * 输入：{1,2,3}
     * 返回值：{3,2,1}
     *
     * 输入：{}
     * 返回值：{}
     */

    /**
     * 一、递归
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 每次next作为新的头，传入递归
        ListNode next = head.next;
        //head=2,next=3  从 2->3 变 2<-3   3.next = 2  2.next = null
        // 递归到底；new_head=4   next=4 head=3;   next=3 head=2;   next=2 head=1;
        ListNode new_head = ReverseList(next);
        // 反转
        next.next = head;
        head.next = null;
        return new_head;
    }

    /**
     * 二、递归
     */
    public ListNode ReverseList2(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    /**
     * 三、非递归
     */
    public ListNode ReverseList3(ListNode head) {
        //新链表
        ListNode newHead = null;
        while (head != null) {
            // 保留头节点到下一个节点，当作下一个头节点
            ListNode temp = head.next;
            // 先把新头指针往后移
            head.next = newHead;
            //再把头，再挂到新头下边
            newHead = head;
            // 头节点更新到下一个节点
            head = temp;
        }
        //返回新链表
        return newHead;
    }

    /**
     * 四、使用栈结构
     */
    public ListNode ReverseList4(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.push(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return newHead;
    }

    /**
     * 一次遍历, 参考：NC21，链表内指定区间反转
     */
    public ListNode ReverseList5(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        ListNode cur_next;
        while (cur.next != null) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode curNode = headNode;

        for (int i = 1; i < 4; i++) {
            curNode.next = new ListNode(i + 1);
            curNode = curNode.next;
        }
//        check(headNode);
//        ListNode resNode1 = new Solution_NC78().ReverseList(headNode);
//        check(resNode1);
//        check(headNode);

//        check(headNode);
//        ListNode resNode2 = new Solution_NC78().ReverseList2(headNode);
//        check(resNode2);
//        check(headNode);

//        System.out.println("=======");
//        check(headNode);
//        ListNode resNode3 = new Solution_NC78().ReverseList3(headNode);
//        check(resNode3);
//        check(headNode);

//        check(headNode);
//        ListNode resNode4 = new Solution_NC78().ReverseList4(headNode);
//        check(resNode4);
//        check(headNode);

        check(headNode);
        ListNode resNode5 = new Solution_NC78().ReverseList5(headNode);
        check(resNode5);
        check(headNode);
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


