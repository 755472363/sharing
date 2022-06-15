package com.hyk.arithmetic;

/**
 * NC21 链表内指定区间反转
 */
public class Solution_NC21_链表内指定区间反转 {
    /**
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
     * 例如：
     * 给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
     * 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
     * <p>
     * 数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
     * 要求：时间复杂度 O(n)O(n) ，空间复杂度 O(n)O(n)
     * 进阶：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
     * <p>
     * 输入：{1,2,3,4,5},2,4
     * 返回值：{1,4,3,2,5}
     * <p>
     * 输入：{5},1,1
     * 返回值：{5}
     */

    /**
     * 一次遍历
     * 参考BM1,代码注解
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // cur 相当于oldHead
        ListNode cur = pre.next;
        ListNode cur_next;
        for (int i = m; i < n; i++) {
            cur_next = cur.next; // oldHead.next肯定是cur_next,先记录，cur_next节点(cur_next会作为新cur,cur_next.next会赋值给oldHead)
            cur.next = cur_next.next;  // cur_next.next节点,复制给oldHead节点
            cur_next.next = pre.next;  // pre.next之前的当前节点，变为cur_next节点后继节点
            pre.next = cur_next; //  cur_next，变为当前节点，复制给pre.next
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode curNode = headNode;

        for (int i = 1; i < 6; i++) {
            curNode.next = new ListNode(i + 1);
            curNode = curNode.next;
        }
        check(headNode);
        ListNode listNode = new Solution_NC21_链表内指定区间反转().reverseBetween(headNode, 2, 5);
        check(listNode);

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


