package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * BM34 判断是不是二叉搜索树
 */
public class Solution_BM34_判断是不是二叉搜索树 {

    /**
     * 判断是不是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null && root.val >= root.right.val) {
            return false;
        }
        if (root.right == null && root.val <= root.left.val) {
            return false;
        }
        if (root.val >= root.right.val && root.val <= root.left.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        boolean isValidBST = new Solution_BM34_判断是不是二叉搜索树().isValidBST(root);
        System.out.println("isValidBST = " + isValidBST);

    }


}



