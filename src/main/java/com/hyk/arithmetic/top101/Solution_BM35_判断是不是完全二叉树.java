package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM35 判断是不是完全二叉树
 */
public class Solution_BM35_判断是不是完全二叉树 {
    /**
     * 基本思路就是，将每层的节点以层序遍历的方式全部放入队列中（包括null）
     * 如果是完全二叉树，在我们取出节点的时候，应该是直到整棵树遍历完毕才会遇到null。
     * 所以当我们按层序遍历的方式，遇到null，但是队列中仍然存在节点，则代表不是完全二叉树；否则，是完全二叉树。
     * <p>
     * 注意⚠️⚠️⚠️：这个思路，就一个节点时，判断逻辑 if (pop == null && queue.size() > 0),会有问题)
     * 并且，并不需要判断，队列长度，参考下边逻辑，flag也没有用到
     */
    public boolean isCompleteTree2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            if (pop == null && queue.size() > 0) {
                return false;
            }
            queue.offer(pop.left);
            queue.offer(pop.right);
        }
        return flag;
    }


    /**
     * 由于判断完全二叉树，当遍历当前层时如果遇到空节点，如果该空节点右侧还有节点，说明该树一定不是完全二叉树，直接返回false，遍历完返回true；
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 是否已到达，最后一个节点
        boolean isEnd = false;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            if (pop == null)
                isEnd = true;
            else {
                // 如果已经是最后节点了，还能走到这里，说明后续还有非空节点（并不需要判断队列长度）
                if (isEnd)
                    return false;
                queue.offer(pop.left);
                queue.offer(pop.right);
            }
        }
        return isEnd;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
////        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);
        root.toString();

        boolean isCompleteTree = new Solution_BM35_判断是不是完全二叉树().isCompleteTree(root);
        System.out.println("isCompleteTree = " + isCompleteTree);

    }


}



