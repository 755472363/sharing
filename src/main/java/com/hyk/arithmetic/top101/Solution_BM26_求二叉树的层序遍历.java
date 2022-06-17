package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BM26 求二叉树的层序遍历
 */
public class Solution_BM26_求二叉树的层序遍历 {


    /**
     * 层序遍历
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            //   return null; 或 return result; 都可以
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int i = 0, curSise = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            while (i < curSise) {
                TreeNode popNode = queue.poll();
                curList.add(popNode.val);
                if (popNode.left != null) {
                    queue.offer(popNode.left);
                }
                if (popNode.right != null) {
                    queue.offer(popNode.right);
                }
                i++;
            }
            result.add(curList);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        ArrayList<ArrayList<Integer>> res = new Solution_BM26_求二叉树的层序遍历().levelOrder(root);
        for (ArrayList<Integer> re : res) {
            System.out.println(re.toString());
        }

    }


}



