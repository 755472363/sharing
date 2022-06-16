package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BM23 二叉树的前序遍历
 */
public class Solution_BM23_二叉树的前序遍历 {

    ArrayList<TreeNode> list = new ArrayList<>();

    /**
     * 前序遍历
     */
    public int[] preorderTraversal(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i).val;
        return res;

    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * 前序遍历
     */
    public int[] preorderTraversal2(TreeNode root) {
        // 添加遍历结果的数组
        ArrayList<Integer> list = new ArrayList<>();
        // 递归前序遍历
        preOrder2(list, root);
        // 返回的结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;

    }

    private void preOrder2(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder2(list, root.left);
        preOrder2(list, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int[] res = new Solution_BM23_二叉树的前序遍历().preorderTraversal2(root);
        System.out.println("===" + Arrays.toString(res));
    }


}



