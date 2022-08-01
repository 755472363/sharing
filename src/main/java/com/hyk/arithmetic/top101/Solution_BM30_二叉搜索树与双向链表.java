package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM30 二叉搜索树与双向链表
 */
public class Solution_BM30_二叉搜索树与双向链表 {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     *    10
     *   6 14
     * 4 8 12 16
     * 转换为双向链表
     * 4 6 8 10 12 14 16
     */


    /**
     * 思路：中序遍历
     */
    private TreeNode pre;
    private TreeNode head;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        //首先递归到最左最小值
        Convert(pRootOfTree.left);
        //找到最小值，初始化head与pre
        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        }
        //当前节点与上一节点建立连接，将pre设置为当前值
        else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pre.right;
        }
        Convert(pRootOfTree.right);
        return head;
    }

    /**
     * 思路：中序遍历，排好序后，新建一个链表。
     */
    Queue<TreeNode> queue = new LinkedList();

    public TreeNode Convert2(TreeNode pRootOfTree) {
        digui(pRootOfTree);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (pre == null) {
                pre = poll;
                head = poll;
            } else {
                pre.right = poll;
                poll.left = pre;
                pre = pre.right;
            }
        }
        return head;
    }

    private void digui(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        //首先递归到最左最小值
        digui(pRootOfTree.left);
        queue.offer(pRootOfTree);
        digui(pRootOfTree.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(8);

        root.toString();
        TreeNode res = new Solution_BM30_二叉搜索树与双向链表().Convert2(root);
        // res双向链表，形成了环，debug模式，toString，会死循环，所以要注释掉toString方法
        TreeNode cur = res;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.right;
        }
        System.out.println("res = " + sb.toString());
    }


}



