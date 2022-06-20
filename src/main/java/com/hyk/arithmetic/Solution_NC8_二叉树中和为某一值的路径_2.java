package com.hyk.arithmetic;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BM29 二叉树中和为某一值的路径(一)
 */
public class Solution_NC8_二叉树中和为某一值的路径_2 {

    /**
     * 方法一：深度优先搜索（推荐使用）
     * 知识点：深度优先搜索（dfs）
     * <p>
     * 思路：
     * 我们从根节点开始向左右子树进行递归，递归函数中需要处理的是：
     * 当前的路径path要更新
     * 当前的目标值expectNumber要迭代，减去当前节点的值
     * 若当前节点是叶子节点，考虑是否满足路径的期待值，并考虑是否将路径添加到返回列表中
     * <p>
     * 具体做法：
     * step 1：维护两个向量ret和path
     * step 2：编写递归函数dfs
     * step 3：递归函数内部要处理更新path，更新expectNumber，判断是否为叶子节点和判断是否要将path追加到ret末尾
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        dfs(root, expectNumber);
        return res;
    }

    private void dfs(TreeNode root, int expectNumber) {
        if (root == null) return;
        path.add(root.val);
        expectNumber -= root.val;
        if (root.left == null && root.right == null && expectNumber == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, expectNumber);
        dfs(root.right, expectNumber);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(4);

        ArrayList<ArrayList<Integer>> res = new Solution_NC8_二叉树中和为某一值的路径_2().FindPath(root, 5);
        for (ArrayList<Integer> re : res) {
            System.out.println(re.toString());
        }

    }


}



