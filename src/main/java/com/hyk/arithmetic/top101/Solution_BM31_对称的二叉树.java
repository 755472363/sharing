package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM31 对称的二叉树
 */
public class Solution_BM31_对称的二叉树 {

    /**
     * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
     */
    
    /**
     * 层序遍历，一个队列（推荐使用）
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null)
                continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val)
                return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    /**
     * 层序遍历，两个队列
     */
    boolean isSymmetrical2(TreeNode pRoot) {
        //空树为对称的
        if (pRoot == null)
            return true;
        //辅助队列用于从两边层次遍历
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        // 1 2的树，不对称，进不去循环，不应该返回true吗？
        // 答：q2队列并不为空，有一个元素，是null，会进入循环
        while (!q1.isEmpty() && !q2.isEmpty()) {
            //分别从左边和右边弹出节点
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            //都为空暂时对称
            if (left == null && right == null)
                continue;
            //某一个为空或者数字不相等则不对称
            if (left == null || right == null || left.val != right.val)
                return false;
            //从左往右加入队列
            q1.offer(left.left);
            q1.offer(left.right);
            //从右往左加入队列
            q2.offer(right.right);
            q2.offer(right.left);
        }
        //都检验完都是对称的
        return true;
    }

    /**
     * 递归：
     * step 1：两种方向的前序遍历，同步过程中的当前两个节点，同为空，属于对称的范畴。
     * step 2：当前两个节点只有一个为空或者节点值不相等，已经不是对称的二叉树了。
     * step 3：第一个节点的左子树与第二个节点的右子树同步递归对比，第一个节点的右子树与第二个节点的左子树同步递归比较。
     */
    boolean isSymmetrical3(TreeNode pRoot) {
        //空树为对称的
        if (pRoot == null)
            return true;
        return recursion(pRoot.left, pRoot.right);
    }

    /**
     * 肯定是对称的
     * -------1
     * -----2--2
     * null-3--3-null
     * <p>
     * <p>
     * 以下情况，在左、右都等于null的时候，会返回true，但是3和4却不对称，不会有问题吗？
     * if (left == null && right == null)
     * <p><p>return true;
     * <p>
     * 答：不会，递归有个&&操作
     * 1，null和null是对称的，返回的true
     * 2，还会校验3-4是否对称，返回的false
     * && 操作后，返回的是false
     * -------1
     * -----2--2
     * null-3--4-null
     */
    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        boolean isSymmetrical = new Solution_BM31_对称的二叉树().isSymmetrical3(root);
        System.out.println("isSymmetrical = " + isSymmetrical);

    }


}



