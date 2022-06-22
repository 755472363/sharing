package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.Arrays;

/**
 * BM40 重建二叉树
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
public class Solution_BM40_重建二叉树 {

    /**
     * 方法一：递归（推荐使用）
     * 思路：
     * 对于二叉树的前序遍历，我们知道序列的第一个元素必定是根节点的值，因为序列没有重复的元素，因此中序遍历中可以找到相同的这个元素，
     * 而我们又知道中序遍历中根节点将二叉树分成了左右子树两个部分，如下图所示：
     * 我们可以发现，数字1是根节点，并将二叉树分成了(247)和(3568)两棵子树，而子树的的根也是相应前序序列的首位，
     * 比如左子树的根是数字2，右子树的根是数字3，这样我们就可以利用前序遍历序列找子树的根节点，利用中序遍历序列区分每个子树的节点数。
     * <p>
     * 具体做法：
     * step 1：先根据前序遍历第一个点建立根节点。
     * step 2：然后遍历中序遍历找到根节点在数组中的位置。
     * step 3：再按照子树的节点数将两个遍历的序列分割成子数组，将子数组送入函数建立子树。
     * step 4：直到子树的序列长度为0，结束递归。
     * <p>
     * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=295&tqId=23282&ru=%2Fpractice%2Fe0cc33a83afe4530bcec46eba3325116&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
     * 前序 1 2 4 7 3 5 6 8
     * 中序 4 7 2 1 5 3 8 6
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0 || vin.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            //找到中序遍历中的前序第一个元素
            if (pre[0] == vin[i]) {
                //构建左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(vin, 0, i));
                //构建右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return root;
    }

    /**
     * 给定后序，中序，确定唯一二叉树
     * 后序 1, 3, 2, 5, 7, 6, 4
     * 中序 1, 2, 3, 4, 5, 6, 7
     */
    public TreeNode reConstructBinaryTree2(int[] post, int[] vin) {
        if (post.length == 0 || vin.length == 0) return null;
        TreeNode root = new TreeNode(post[post.length - 1]);
        for (int i = 0; i < vin.length; i++) {
            //找到中序遍历中的前序第一个元素
            if (post[post.length - 1] == vin[i]) {
                //构建左子树
                root.left = reConstructBinaryTree2(Arrays.copyOfRange(post, 0, i), Arrays.copyOfRange(vin, 0, i));
                //构建右子树
                root.right = reConstructBinaryTree2(Arrays.copyOfRange(post, i, post.length - 1), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
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

        TreeNode reConstructBinaryTree = new Solution_BM40_重建二叉树().reConstructBinaryTree(pre, vin);
        reConstructBinaryTree.toString();

        TreeNode reConstructBinaryTree2 = new Solution_BM40_重建二叉树().reConstructBinaryTree2(post, vin);
        reConstructBinaryTree2.toString();


    }


}



