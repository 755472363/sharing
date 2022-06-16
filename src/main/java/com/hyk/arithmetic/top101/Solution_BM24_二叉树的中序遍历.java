package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BM24 二叉树的中序遍历
 */
public class Solution_BM24_二叉树的中序遍历 {


    /**
     * 中序遍历
     */
    public int[] inorderTraversal(TreeNode root) {
        // 添加遍历结果的数组
        ArrayList<Integer> list = new ArrayList<>();
        // 中序遍历
        inorder(list, root);
        // 返回的结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;

    }

    private void inorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int[] res = new Solution_BM24_二叉树的中序遍历().inorderTraversal(root);
        System.out.println("===" + Arrays.toString(res));
    }


}



