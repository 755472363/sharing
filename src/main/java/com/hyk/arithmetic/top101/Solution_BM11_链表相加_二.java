package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

import java.util.Stack;

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


    /**
     * 方法二：
     * 使用辅助栈，反转链表，相加后，再组装成新链表
     */
    public ListNode addInList2(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int jinwei = 0;
        ListNode newHead = null;
        ListNode pre = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode pop1 = stack1.pop();
            ListNode pop2 = stack2.pop();
            int popCount = pop1.val + pop2.val + jinwei;
            jinwei = popCount >= 10 ? 1 : 0;
            newHead = new ListNode(popCount % 10);
            newHead.next = pre;
            pre = newHead;
        }
        while (!stack1.isEmpty()) {
            ListNode pop1 = stack1.pop();
            int popCount = pop1.val + jinwei;
            jinwei = popCount >= 10 ? 1 : 0;
            newHead = new ListNode(popCount % 10);
            newHead.next = pre;
            pre = newHead;
        }
        while (!stack2.isEmpty()) {
            ListNode pop2 = stack2.pop();
            int popCount = pop2.val + jinwei;
            jinwei = popCount >= 10 ? 1 : 0;
            newHead = new ListNode(popCount % 10);
            newHead.next = pre;
            pre = newHead;
        }
        if (jinwei > 0) {
            newHead = new ListNode(1);
            newHead.next = pre;
        }

        return newHead;
    }

    /**
     * 方法二：
     * 使用辅助栈，上述方法，简化循环写法
     */
    public ListNode addInList3(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int jinwei = 0;
        ListNode newHead = null;
        ListNode pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int popCount = jinwei;
            if (!stack1.isEmpty()) {
                ListNode pop1 = stack1.pop();
                popCount += pop1.val;
            }
            if (!stack2.isEmpty()) {
                ListNode pop2 = stack2.pop();
                popCount += pop2.val;
            }
            jinwei = popCount >= 10 ? 1 : 0;
            newHead = new ListNode(popCount % 10);
            newHead.next = pre;
            pre = newHead;
        }
        if (jinwei > 0) {
            newHead = new ListNode(1);
            newHead.next = pre;
        }

        return newHead;
    }

    /**
     * 方法一：反转链表
     * 代码复制的，和辅助栈，逻辑类似
     * 时间复杂度:方法一和二都为O(n)。取决于链表的长度。
     * 空间复杂度:方法一没有用到额外的空间，所以为O(1)。
     */
    public ListNode addInList4(ListNode head1, ListNode head2) {
        // 进行判空处理
        if (head1 == null)
            return head2;
        if (head2 == null) {
            return head1;
        }
        // 反转h1链表
        head1 = reverse(head1);
        // 反转h2链表
        head2 = reverse(head2);
        // 创建新的链表头节点
        ListNode head = new ListNode(-1);
        ListNode nHead = head;
        // 记录进位的数值
        int tmp = 0;
        while (head1 != null || head2 != null) {
            // val用来累加此时的数值（加数+加数+上一位的进位=当前总的数值）
            int val = tmp;
            // 当节点不为空的时候，则需要加上当前节点的值
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            // 当节点不为空的时候，则需要加上当前节点的值
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            // 求出进位
            tmp = val / 10;
            // 进位后剩下的数值即为当前节点的数值
            nHead.next = new ListNode(val % 10);
            // 下一个节点
            nHead = nHead.next;

        }
        // 最后当两条链表都加完的时候，进位不为0的时候，则需要再加上这个进位
        if (tmp > 0) {
            nHead.next = new ListNode(tmp);
        }
        // 重新反转回来返回
        return reverse(head.next);
    }

    // 反转链表
    ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode node = null;
        while (cur != null) {
            ListNode tail = cur.next;
            cur.next = node;
            node = cur;
            cur = tail;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode headNode9 = new ListNode(9);
        ListNode headNode3 = new ListNode(3);
        ListNode headNode7 = new ListNode(7);
        headNode9.next = headNode3;
        headNode3.next = headNode7;

        ListNode headNode6 = new ListNode(6);
        ListNode headNode33 = new ListNode(3);
        headNode6.next = headNode33;

        check(headNode9);
        check(headNode6);
//        check(new Solution_BM4().Merge(headNode1, headNode1));
        check(new Solution_BM11_链表相加_二().addInList3(headNode9, headNode6));
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



