package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BM33 二叉树的镜像
 */
public class Solution_BM33_二叉树的镜像 {

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * <p>
     * 思路：
     * 因为我们需要将二叉树镜像，意味着每个左右子树都会交换位置，如果我们从上到下对遍历到的节点交换位置，但是它们后面的节点无法跟着他们一起被交换，
     * 因此我们可以考虑自底向上对每两个相对位置的节点交换位置，这样往上各个子树也会被交换位置。
     * 自底向上的遍历方式，我们可以采用后序递归的方法。
     * <p>
     * 具体做法：
     * step 1：先深度最左端的节点，遇到空树返回，处理最左端的两个子节点交换位置。
     * step 2：然后进入右子树，继续按照先左后右再回中的方式访问。
     * step 3：再返回到父问题，交换父问题两个子节点的值。
     */
    // 后序遍历
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    /**
     * 方法二：栈（扩展思路）
     * 二叉树中能够用递归的，我们大多也可以用栈来实现。栈的访问是一种自顶向下的访问
     * 我们需要在左右子节点入栈后直接交换，然后再访问后续栈中内容。
     */
    // 层序遍历+栈
    public TreeNode Mirror2(TreeNode pRoot) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            pRoot.toString();
        }
        return pRoot;
    }

    // 层序遍历+队列
    public TreeNode Mirror3(TreeNode pRoot) {
        if (pRoot == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            pRoot.toString();
        }
        return pRoot;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.toString();
        TreeNode Mirror = new Solution_BM33_二叉树的镜像().Mirror2(root);
    }


}



