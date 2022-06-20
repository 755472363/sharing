package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * NC8 二叉树中和为某一值的路径(二)
 */
public class Solution_BM29_二叉树中和为某一值的路径_1 {

    /**
     * 二叉树递归
     * 终止条件： 每当遇到节点为空，意味着过了叶子节点，返回。每当检查到某个节点没有子节点，它就是叶子节点，此时sum减去叶子节点值刚好为0，说明找到了路径。
     * 返回值： 将子问题中是否有符合新目标值的路径层层往上返回。
     * 本级任务： 每一级需要检查是否到了叶子节点，如果没有则递归地进入子节点，同时更新sum值减掉本层的节点值。
     * 具体做法：
     * step 1：每次检查遍历到的节点是否为空节点，空节点就没有路径。
     * step 2：再检查遍历到是否为叶子节点，且当前sum值等于节点值，说明可以刚好找到。
     * step 3：检查左右子节点是否可以有完成路径的，如果任意一条路径可以都返回true，因此这里选用两个子节点递归的
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        boolean isValidBST = new Solution_BM29_二叉树中和为某一值的路径_1().hasPathSum(root, 5);
        System.out.println("isValidBST = " + isValidBST);

    }


}



