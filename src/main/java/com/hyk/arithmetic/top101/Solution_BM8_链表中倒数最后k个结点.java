package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM8 链表中倒数最后k个结点
 */
public class Solution_BM8_链表中倒数最后k个结点 {

    /**
     * 思想我的：
     * 先遍历一遍，统计有count个
     * 在遍历count-k次，返回节点
     * <p>
     * 算法思想二：栈
     * 解题思路：
     * 把原链表的结点全部压栈，然后再把栈中最上面的k个节点出栈，出栈的结点重新串成一个新的链表即可
     * <p>
     * 两种思路相似
     * 最优解法，快慢指针。
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode temp = pHead;
        int count = 0;
        while (pHead != null) {
            count++;
            pHead = pHead.next;
        }
        if (count < k)
            return null;
        int j = count - k;
        int i = 0;
        while (i < j) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    /**
     * 算法思想一：快慢指针
     * 解题思路：
     * 第一个指针先移动k步，然后第二个指针再从头开始，这个时候这两个指针同时移动，当第一个指针到链表的末尾的时候，返回第二个指针即可
     */
    public ListNode FindKthToTail2(ListNode pHead, int k) {
        int fast = 0;
        ListNode fastCurr = pHead;
        while (fast < k) {
            if (fastCurr != null) {
                fastCurr = fastCurr.next;
                fast++;
            } else {
                return null;
            }
        }
        ListNode slowCurr = pHead;
        while (fastCurr != null) {
            fastCurr = fastCurr.next;
            slowCurr = slowCurr.next;
        }
        return slowCurr;
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
        ListNode newHead = new Solution_BM8_链表中倒数最后k个结点().FindKthToTail2(head, 5);
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



