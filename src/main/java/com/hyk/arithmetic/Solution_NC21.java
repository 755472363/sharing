package com.hyk.arithmetic;

/**
 * NC21 链表内指定区间反转
 */
public class Solution_NC21 {
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


    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode curNode = headNode;

        for (int i = 1; i < 4; i++) {
            curNode.next = new ListNode(i + 1);
            curNode = curNode.next;
        }
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


