package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.Stack;

/**
 * BM3_链表中的节点每k个一组翻转
 */
public class Solution_BM3_链表中的节点每k个一组翻转 {

    /**
     * 利用栈的先进后出规则实现链表的翻转
     * 1、首先遍历链表k个结点入栈，若k大于链表的长度则直接返回链表不翻转
     * 2、栈内结点出栈（翻转）
     * 3、判断剩下的链表个数够不够k个（少于k个不需要反转，大于k个重复 1、2步骤）
     * 4、将已翻转的部分与剩下的链表连接起来
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (i < k && head != null) {
            stack.push(head);
            head = head.next;
            i++;
        }
        if (stack.size() < k) {
            return temp;
        }
        ListNode newHead = stack.pop();
        ListNode curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        ListNode nextNewHead = reverseKGroup(head, k);
        curr.next = nextNewHead;
        return newHead;
    }

    public static void main(String[] args) {
        int i = 2;
        int k = 4;
        ListNode head = new ListNode(1);
        ListNode curr = head;
        while (i <= k) {
            curr.next = new ListNode(i);
            curr = curr.next;
            i++;
        }
        check(head);
        ListNode newHead = new Solution_BM3_链表中的节点每k个一组翻转().reverseKGroup(head, 2);
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



