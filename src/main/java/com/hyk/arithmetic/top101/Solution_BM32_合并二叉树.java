package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * BM32 合并二叉树
 */
public class Solution_BM32_合并二叉树 {

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left, t2.left);
        head.right = mergeTrees(t1.right, t2.right);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);


        TreeNode isValidBST = new Solution_BM32_合并二叉树().mergeTrees(root, root2);
        System.out.println("====");
    }


}



