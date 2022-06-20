package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BM33 二叉树的镜像
 */
public class Solution_BM33_二叉树的镜像 {

    /**
     * 方法一：递归前序遍历（推荐使用）
     * <p>
     * 思路：
     * 要将一棵二叉树的节点与另一棵二叉树相加合并，肯定需要遍历两棵二叉树，
     * 那我们可以考虑同步遍历两棵二叉树，这样就可以将每次遍历到的值相加在一起。遍历的方式有多种，这里推荐前序递归遍历。
     * <p>
     * 具体做法：
     * step 1：首先判断t1与t2是否为空，若为则用另一个代替，若都为空，返回的值也是空。
     * step 2：然后依据前序遍历的特点，优先访问根节点，将两个根点的值相加创建到新树中。
     * step 3：两棵树再依次同步进入左子树和右子树。
     */
    // 后序遍历
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    /**
     * 方法二：栈（扩展思路）
     * 二叉树中能够用递归的，我们大多也可以用栈来实现。栈的访问是一种自顶向下的访问
     * 我们需要在左右子节点入栈后直接交换，然后再访问后续栈中内容。
     */
    // 层序遍历+栈
    public TreeNode Mirror2(TreeNode pRoot) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            System.out.println(pRoot.toString());
        }
        return pRoot;
    }

    // 层序遍历+队列
    public TreeNode Mirror3(TreeNode pRoot) {
        if (pRoot == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            System.out.println(pRoot.toString());
        }
        return pRoot;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("root.toString() = " + root.toString());
        TreeNode Mirror = new Solution_BM33_二叉树的镜像().Mirror2(root);
    }


}



