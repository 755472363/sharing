package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.ListNode;

/**
 * BM14 链表的奇偶重排
 */
public class Solution_BM14_链表的奇偶重排 {

    /**
     * 思路（错误，错误，错误）：双指针(遍历两遍，第一次遍历所有奇数节点，第二次遍历所有偶数节点，组装成新的链表)
     * 所以该思路不对，需要调整一下。
     * 1-10个几点，这种会导致奇数节点遍历完，到9节点，在遍历偶数节点2345678910，因为都是指针引用，会生成2-9的环，导致栈益处。
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
        while (ouNode != null && ouNode.next != null) {
            cur.next = ouNode;
            cur = cur.next;
            ouNode = ouNode.next.next;
        }
        return dummyNode.next;
    }

    /**
     * 思路：双指针(两个指针，同时遍历链表，奇数的组成一个链表，偶数组成一个链表，遍历结束后，奇数链表的尾部，为偶数链表的头，提供一个头，组装成新的链表)
     * 具体做法： odd 奇数  even 偶数
     * step 1：判断空链表的情况，如果链表为空，不用重排。
     * step 2：使用双指针odd和even分别遍历奇数节点和偶数节点，并给偶数节点链表一个头。
     * step 3：上述过程，每次遍历两个节点，且even在后面，因此每轮循环用even检查后两个元素是否为NULL(这句话不对，是检测even和后边一个元素即可)，如果不为再进入循环进行上述连接过程。
     * step 4：将偶数节点头接在奇数最后一个节点后，再返回头部。
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode jiCurNode = head;
        ListNode ouHeadNode = head.next;
        ListNode ouCurNode = ouHeadNode;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = jiCurNode;
        while (ouCurNode != null && ouCurNode.next != null) {
            jiCurNode.next = ouCurNode.next;
            jiCurNode = jiCurNode.next;
            ouCurNode.next = jiCurNode.next;
            ouCurNode = ouCurNode.next;
        }

        // 当前奇节点尾部，接，偶节点的头部。
        jiCurNode.next = ouHeadNode;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int i = 2;
        int k = 9;
        ListNode head = new ListNode(1);
        ListNode curr = head;
        while (i <= k) {
            curr.next = new ListNode(i);
            curr = curr.next;
            i++;
        }
        check(head);
        ListNode newHead = new Solution_BM14_链表的奇偶重排().oddEvenList2(head);
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



