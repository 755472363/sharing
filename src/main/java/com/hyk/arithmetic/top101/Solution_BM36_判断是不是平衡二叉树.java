package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * BM36 判断是不是平衡二叉树
 */
public class Solution_BM36_判断是不是平衡二叉树 {

    /**
     * 思路1：自上而下，前序遍历（推荐使用）
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int leftDef = getDepth(root.left);
        int rightDef = getDepth(root.right);
        if (Math.abs(leftDef - rightDef) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    /**
     * 思路2：自下而上，后序遍历（扩展思路）
     * 复制的代码
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        //空树也是平衡二叉树
        if (root == null)
            return true;
        return getdepth2(root) != -1;
    }

    private int getdepth2(TreeNode root) {
        if (root == null)
            return 0;
        //递归计算当前root左右子树的深度差
        int left = getdepth2(root.left);
        //当前节点左子树不平衡，则该树不平衡
        if (left < 0)
            return -1;
        int right = getdepth2(root.right);
        //当前节点右子树不平衡，则该树不平衡
        if (right < 0)
            return -1;
        //计算深度差
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        root.toString();
        boolean res = new Solution_BM36_判断是不是平衡二叉树().IsBalanced_Solution(root);
        System.out.println("res = " + res);
    }


}



