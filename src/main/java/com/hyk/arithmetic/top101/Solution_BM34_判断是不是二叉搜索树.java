package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * BM34 判断是不是二叉搜索树
 */
public class Solution_BM34_判断是不是二叉搜索树 {

    /**
     * 错误的
     * 判断是不是二叉搜索树
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            if (root.val <= root.right.val && root.val >= root.left.val) {
                return isValidBST2(root.left) && isValidBST2(root.right);
            } else {
                return false;
            }
        } else if (root.left != null) {
            if (root.val >= root.left.val) {
                return isValidBST2(root.left);
            } else {
                return false;
            }
        } else {
            if (root.val <= root.right.val) {
                return isValidBST2(root.right);
            } else {
                return false;
            }
        }
    }

    /**
     * 利用二叉搜索树的特性：中序遍历为升序，遍历二叉树即可。
     * 每次记录一下前驱节点的值，判断当前节点是否比前驱节点大.
     * 如果比前驱小，则遍历结束。如果遍历到最后一个节点还是满足则为二叉搜索树。
     * --2
     * 1   3
     * 有点绕，不太好理解
     */
    int pre = Integer.MIN_VALUE;

    //中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        //先进入左子树
        if (!isValidBST(root.left))
            return false;
        if (root.val < pre)
            return false;
        //更新最值
        pre = root.val;
        //再进入右子树
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        boolean isValidBST = new Solution_BM34_判断是不是二叉搜索树().isValidBST(root);
        System.out.println("isValidBST = " + isValidBST);

    }


}



