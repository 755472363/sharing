package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM11 链表相加(二)
 */
public class Solution_BM11_链表相加_二 {

    /**
     * 输入：[9,3,7],[6,3]
     * 返回值：{1,0,0,0}
     * 937 + 63 = 1000
     */

    /**
     * 错误思路（错误错误错误）：变成数字，相加后，在一个一个拆出来，组成新联调（想法很好，但是是不对的）
     * 链表可能很长，超过了int，long类型，无法计算；
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        int num1 = 0;
        int num2 = 0;
        while (head1 != null) {
            num1 = num1 * 10 + head1.val;
            head1 = head1.next;
        }
        while (head2 != null) {
            num2 = num2 * 10 + head2.val;
            head2 = head2.next;
        }
        int count = num1 + num2;

        ListNode newHead = null;
        ListNode oldHead = null;
        while (count > 0) {
            newHead = new ListNode(count % 10);
            newHead.next = oldHead;
            oldHead = newHead;
            count = count / 10;
        }
        return newHead;
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
        check(headNode1);
        check(headNode2);
//        check(new Solution_BM4().Merge(headNode1, headNode1));
        check(new Solution_BM11_链表相加_二().addInList(headNode1, headNode2));
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



