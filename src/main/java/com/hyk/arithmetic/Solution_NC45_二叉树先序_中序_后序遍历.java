package com.hyk.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * NC45 实现二叉树先序，中序和后序遍历
 */
public class Solution_NC45_二叉树先序_中序_后序遍历 {
    /**
     * 数据范围：0 \le n \le 10000≤n≤1000，树上每个节点的val值满足 0 \le val \le 1000≤val≤100
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
     * 示例1
     * 1
     * 2   3
     * 输入：{1,2,3}
     * 返回值：[[1,2,3],[2,1,3],[2,3,1]]
     */

    public int[][] threeOrders(TreeNode root) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // 调用函数
        //调用函数计算遍历结果
        preOrder(root, list1);
        inOrder(root, list2);
        postOrder(root, list3);

        int[][] res = new int[3][list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);

        }
        //答案返回
        return res;
    }

    // 前序遍历
    private void preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // 中序遍历
    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // 后序遍历
    private void postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    /**
     * 4
     * 2 6
     * 13 57
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(5);
        TreeNode root7 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;


        Solution_NC45_二叉树先序_中序_后序遍历 nc68 = new Solution_NC45_二叉树先序_中序_后序遍历();
        int[][] result = nc68.threeOrders(root);
        for (int[] ints : result) {
            System.out.println("====" + Arrays.toString(ints));
        }

    }

}



