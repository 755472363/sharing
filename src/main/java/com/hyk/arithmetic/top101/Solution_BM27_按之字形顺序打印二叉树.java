package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM27 按之字形顺序打印二叉树
 */
public class Solution_BM27_按之字形顺序打印二叉树 {


    /**
     * 思路：
     * 按照层次遍历按层打印二叉树的方式，每层分开打印，然后对于每一层利用flag标记，第一层为false，
     * 之后每到一层取反一次，如果该层的flag为true，则记录的数组整个反转即可。
     * Collections.reverse(list);
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int i = 0, size = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            while (i < size) {
                TreeNode pop = queue.poll();
                curList.add(pop.val);
                if (pop.left != null)
                    queue.offer(pop.left);
                if (pop.right != null)
                    queue.offer(pop.right);
                i++;
            }
            flag = !flag;
            if (flag)
                Collections.reverse(curList);
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

        ArrayList<ArrayList<Integer>> res = new Solution_BM27_按之字形顺序打印二叉树().Print(root);
        for (ArrayList<Integer> re : res) {
            System.out.println(re.toString());
        }

    }


}



