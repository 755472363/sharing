package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.Stack;

/**
 * BM1.反转链表
 */
public class Solution_BM1_反转链表 {

    // 迭代
    public ListNode ReverseList(ListNode head) {
        if (head == null) //处理空链表
            return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next; //断开链表，要记录后续⼀个
            cur.next = pre; //当前的next指向前⼀个
            pre = cur; //前⼀个更新为当前
            cur = temp; //当前更新为刚刚记录的后⼀个
        }
        return pre;
    }

    // 递归
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = ReverseList2(head.next); //反转下⼀个
        head.next.next = head; //逆转
        head.next = null; //尾部设置空结点
        return newHead;
    }

    // 栈
    public ListNode ReverseList3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }

    //
    public ListNode ReverseList4(ListNode head) {
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
        ListNode curr = new ListNode(1);
        curr.next = new ListNode(2);
        curr.next.next = new ListNode(3);
        check(curr);
        ListNode newHead = new Solution_BM1_反转链表().ReverseList4(curr);
        check(newHead);
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



