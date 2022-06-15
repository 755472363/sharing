package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM14 链表的奇偶重排
 */
public class Solution_BM14_链表的奇偶重排 {

    /**
     * 思路：双指针(遍历两遍，第一次遍历所有奇数节点，第二次遍历所有偶数节点，组装成新的链表)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode jiNode = head;
        ListNode ouNode = head.next;

        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (jiNode != null && jiNode.next != null) {
            cur.next = jiNode;
            cur = cur.next;
            jiNode = jiNode.next.next;
        }
//        if (cur.next != null) {
//            cur.next = null;
//        }
        while (ouNode != null && ouNode.next != null) {
            cur.next = ouNode;
            cur = cur.next;
            ouNode = ouNode.next.next;
        }
        return dummyNode.next;
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
        ListNode newHead = new Solution_BM14_链表的奇偶重排().oddEvenList(head);
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



