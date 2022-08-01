package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM41 输出二叉树的右视图
 * （已知：前序和中序，重构二叉树）
 * （已知：后序和中序，重构二叉树）
 * <p>
 * https://blog.csdn.net/qq_41945348/article/details/106876239
 * 结论
 * 有上述的两道题，也可得知二叉树的连个性质：
 * 已知前序遍历结果和中序遍历结果，可以确定唯一一颗二叉树。
 * 已知后序遍历结果和中序遍历结果，可以确定唯一一颗二叉树。
 * 但是，已知前序遍历结果和后序遍历结果，是不能确定一颗二叉树。比如：前序序列3、6和 后序序列6、3。可以确定3是根节点，但是接下来的结果可能是多种的。如图4所示：
 * 3     3
 * 6#    #6
 */
public class Solution_BM41_输出二叉树的右视图 {

    /**
     * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
     * <p>
     * 方法一：递归建树+层序遍历
     * <p>
     * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=295&tqId=23282&ru=%2Fpractice%2Fe0cc33a83afe4530bcec46eba3325116&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
     * 前序 1 2 4 7 3 5 6 8
     * 中序 4 7 2 1 5 3 8 6
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0 || zhongxu.length == 0) return new int[0];
        TreeNode root = buildTree(xianxu, zhongxu);
        root.toString();
        ArrayList<Integer> list = cengxu(root);
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i] = integer;
            i++;
        }
        return res;
    }

    private ArrayList<Integer> cengxu(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int i = 0, size = queue.size();
            while (i < size) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    res.add(poll.val);
                }
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
                i++;
            }
        }
        return res;
    }

    private TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0 || zhongxu.length == 0) return null;
        TreeNode root = new TreeNode(xianxu[0]);
        for (int i = 0; i < zhongxu.length; i++) {
            if (xianxu[0] == zhongxu[i]) {
                root.left = buildTree(Arrays.copyOfRange(xianxu, 1, i + 1), Arrays.copyOfRange(zhongxu, 0, i));
                root.right = buildTree(Arrays.copyOfRange(xianxu, i + 1, xianxu.length), Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
            }
        }
        return root;
    }


    /**
     * 4
     * 2 6
     * 1 3 5 7
     */
    public static void main(String[] args) {
        int[] pre = {4, 2, 1, 3, 6, 5, 7};
        int[] vin = {1, 2, 3, 4, 5, 6, 7};
        int[] post = {1, 3, 2, 5, 7, 6, 4};

        int[] solve = new Solution_BM41_输出二叉树的右视图().solve(pre, vin);
        System.out.println(Arrays.toString(solve));

    }


}



