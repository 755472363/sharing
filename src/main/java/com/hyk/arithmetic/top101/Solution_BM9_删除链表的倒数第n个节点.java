package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM9 删除链表的倒数第n个节点
 */
public class Solution_BM9_删除链表的倒数第n个节点 {

    /**
     * 参考BM8,快指针多移动1，n可能等于节点数，就是去掉第一个元素。n+1会多遍历一次
     * 需要特别注意：如果fast为空，表示删除的是头结点，return head.next;
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int fast = 0;
        ListNode fastCurr = head;
        while (fast < n + 1) {
            if (fastCurr != null) {
                fastCurr = fastCurr.next;
                fast++;
            } else {
                // 如果fast为空，表示删除的是头结点
                return head.next;
            }
        }
        ListNode slowCurr = head;
        while (fastCurr != null) {
            fastCurr = fastCurr.next;
            slowCurr = slowCurr.next;
        }
        slowCurr.next = slowCurr.next.next;
        return head;
    }


    /**
     * 双指针，参考BM8
     * 快慢指针同步移动，出去的条件是：fast.next == null,可以提前一个结束。
     * 之前是fast == null
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int fast = 0;
        ListNode fastCurr = head;
        while (fast < n) {
            // 题目保证 nn 一定是有效的
            fastCurr = fastCurr.next;
            fast++;
        }
        if (fastCurr == null) {
            //如果fastCurr为空，表示删除的是头结点
            return head.next;
        }
        ListNode slowCurr = head;
        while (fastCurr.next != null) {
            fastCurr = fastCurr.next;
            slowCurr = slowCurr.next;
        }
        slowCurr.next = slowCurr.next.next;
        return head;
    }

    public static void main(String[] args) {
        int i = 2;
        int k = 10;
        ListNode head = new ListNode(1);
        ListNode curr = head;
        while (i <= k) {
            curr.next = new ListNode(i);
            curr = curr.next;
            i++;
        }
        check(head);
        ListNode newHead = new Solution_BM9_删除链表的倒数第n个节点().removeNthFromEnd2(head, 5);
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



