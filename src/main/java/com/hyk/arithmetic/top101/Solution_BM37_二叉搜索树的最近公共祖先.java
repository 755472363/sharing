package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;

/**
 * BM37 二叉搜索树的最近公共祖先
 */
public class Solution_BM37_二叉搜索树的最近公共祖先 {

    /**
     * 方法一：搜索路径比较（推荐使用）
     * 二叉搜索树没有相同值的节点，因此分别从根节点往下利用二叉搜索树较大的数在右子树，较小的数在左子树，可以轻松找到p、q：
     * 直接得到从根节点到两个目标节点的路径，这样我们利用路径比较就可以找到最近公共祖先。
     * <p>
     * 具体做法：
     * step 1：根据二叉搜索树的性质，从根节点开始查找目标节点，当前节点比目标小则进入右子树，当前节点比目标大则进入左子树，直到找到目标节点。这个过程成用数组记录遇到的元素。
     * step 2：分别在搜索二叉树中找到p和q两个点，并记录各自的路径为数组。
     * step 3：同时遍历两个数组，比较元素值，最后一个相等的元素就是最近的公共祖先。
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return -1;
        ArrayList<Integer> path_1 = getPath(root, p);
        ArrayList<Integer> path_2 = getPath(root, q);
        int res = -1;
        for (int i = 0; i < path_1.size() && i < path_2.size(); i++) {
            int k1 = path_1.get(i);
            int k2 = path_2.get(i);
            if (k1 == k2) {
                res = k1;
            } else {
                break;
            }
        }
        return res;
    }

    private ArrayList<Integer> getPath(TreeNode root, int taget) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node.val != taget) {
            list.add(node.val);
            if (node.val < taget) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        list.add(node.val);
        return list;
    }

    /**
     * 方法二：一次遍历（扩展思路）
     * 我们也可以利用二叉搜索树的性质：对于某一个节点若是p与q都小于等于这个这个节点值，说明p、q都在这个节点的左子树，而最近的公共祖先也一定在这个节点的左子树；
     * 若是p与q都大于等于这个节点，说明p、q都在这个节点的右子树，而最近的公共祖先也一定在这个节点的右子树。
     * 而若是对于某个节点，p与q的值一个大于等于节点值，一个小于等于节点值，说明它们分布在该节点的两边，而这个节点就是最近的公共祖先，
     * 因此从上到下的其他祖先都将这个两个节点放到同一子树，只有最近公共祖先会将它们放入不同的子树，每次进入一个子树又回到刚刚的问题，因此可以使用递归。
     * <p>
     * 具体做法：
     * step 1：首先检查空节点，空树没有公共祖先。
     * step 2：对于某个节点，比较与p、q的大小，若p、q在该节点两边说明这就是最近公共祖先。
     * step 3：如果p、q都在该节点的左边，则递归进入左子树。
     * step 4：如果p、q都在该节点的右边，则递归进入右子树。
     */
    public int lowestCommonAncestor2(TreeNode root, int p, int q) {
        if (root == null) return -1;
        if ((root.val <= p && root.val >= q) || (root.val >= p && root.val <= q)) {
            return root.val;
        } else if (root.val <= p && root.val <= q) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return lowestCommonAncestor2(root.left, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.toString();

        int lowestCommonAncestor = new Solution_BM37_二叉搜索树的最近公共祖先().lowestCommonAncestor2(root, 1, 3);
        System.out.println("lowestCommonAncestor = " + lowestCommonAncestor);


    }


}



