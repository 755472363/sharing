package com.hyk.arithmetic;


import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (this == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int i = 0, curSise = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            while (i < curSise) {
                TreeNode popNode = queue.poll();
                curList.add(popNode.val);
                if (popNode.left != null) {
                    queue.offer(popNode.left);
                }
                // 这里是if，不是else if
                if (popNode.right != null) {
                    queue.offer(popNode.right);
                }
                i++;
            }
            result.add(curList);
        }
        StringBuilder toString = new StringBuilder();
        for (ArrayList<Integer> integers : result) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (Integer integer : integers) {
                sb.append(integer).append(" ");
            }
            toString.append(sb);
        }
        System.out.println(toString.toString());
        return toString.toString();
    }
}
 
