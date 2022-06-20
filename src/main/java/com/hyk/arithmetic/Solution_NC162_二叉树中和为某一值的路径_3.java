package com.hyk.arithmetic;


/**
 * NC162 二叉树中和为某一值的路径(三)
 */
public class Solution_NC162_二叉树中和为某一值的路径_3 {

    /**
     * 输入：{1,2,3,4,5,4,3,#,#,-1},6
     * 返回：3
     * 说明：如图所示，有3条路径符合
     * <p>
     * 方法一：两次遍历（推荐使用）
     * <p>
     * 思路：
     * 既然要找所有路径上节点和等于目标值的路径个数，那我们肯定先找这样的路径起点啊，
     * 但是我们不知道起点究竟在哪里，而且任意节点都有可能是起点，
     * 那我们就前序遍历二叉树的所有节点，每个节点都可以作为一次起点，即子树的根节点。
     */
    private int res = 0;

    public int FindPath(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            res++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        int res = new Solution_NC162_二叉树中和为某一值的路径_3().FindPath(root, 5);
        System.out.println("res = " + res);

    }


}



