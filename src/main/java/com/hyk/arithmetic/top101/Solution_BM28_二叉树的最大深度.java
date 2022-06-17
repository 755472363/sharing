package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM28 二叉树的最大深度
 */
public class Solution_BM28_二叉树的最大深度 {


    /**
     * 二叉树的最大深度
     * 深度优先遍历（Depth First Search, 简称 DFS） 与广度优先遍历（Breadth First Search）是图论中两种非常重要的算法
     * 生产上广泛用于拓扑排序，寻路（走迷宫），搜索引擎，爬虫等，也频繁出现在 leetcode，高频面试题中。
     */

    /**
     * 定义递归函数功能：获取root结点的最大深度
     * 递归终止条件：root为null
     * 返回值：先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
     * 时间复杂度 O(N)：计算所有结点的深度的递归需要经过每个结点
     * 空间复杂度 O(N)：递归占用的栈空间
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 层序遍历，求出最大深度
     * 时间复杂度 O(N)：平均需要遍历所有结点
     * 空间复杂度 O(N)：用到了队列，N为队列长度
     */
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int i = 0, size = queue.size();
            while (i < size) {
                TreeNode popNode = queue.poll();
                if (popNode.left != null) {
                    queue.offer(popNode.left);
                }
                // 这里是if，不是else if
                if (popNode.right != null) {
                    queue.offer(popNode.right);
                }
                i++;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int depth = new Solution_BM28_二叉树的最大深度().maxDepth2(root);
        System.out.println("depth = " + depth);

    }


}



