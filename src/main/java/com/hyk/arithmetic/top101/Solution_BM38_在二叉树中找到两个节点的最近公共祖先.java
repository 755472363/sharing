package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

import java.util.ArrayList;

/**
 * BM38 在二叉树中找到两个节点的最近公共祖先
 */
public class Solution_BM38_在二叉树中找到两个节点的最近公共祖先 {

    /**
     * 方法一：路径比较法(推荐使用)
     * 思路：
     * 既然要找到二叉树中两个节点的最近公共祖先，那我们可以考虑先找到两个节点全部祖先，可以得到从根节点到目标节点的路径，然后依次比较路径得出谁是最近的祖先。
     * 找到两个节点的所在可以深度优先搜索遍历二叉树所有节点进行查找。
     * <p>
     * 具体做法：
     * step 1：利用dfs求得根节点到两个目标节点的路径：每次选择二叉树的一棵子树往下找，同时路径数组增加这个遍历的节点值。
     * step 2：一旦遍历到了叶子节点也没有，则回溯到父节点，寻找其他路径，回溯时要去掉数组中刚刚加入的元素。
     * step 3：然后遍历两条路径数组，依次比较元素值。
     * step 4：找到两条路径第一个不相同的节点即是最近公共祖先。
     */
    public int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        if (root == null) return -1;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        dfs(root, list1, o1);
        //重置flag，查找下一个
        flag = false;
        dfs(root, list2, o2);
        int res = -1;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            int k1 = list1.get(i);
            int k2 = list2.get(i);
            if (k1 == k2) {
                res = k1;
            } else {
                break;
            }
        }
        return res;
    }

    //记录是否找到到o的路径
    public boolean flag = false;

    private void dfs(TreeNode root, ArrayList<Integer> list, int taget) {
        if (flag || root == null)
            return;
        list.add(root.val);
        //节点值都不同，可以直接用值比较
        if (root.val == taget) {
            flag = true;
            return;
        }
        //dfs遍历查找
        dfs(root.left, list, taget);
        dfs(root.right, list, taget);
        //找到
        if (flag)
            return;
        //回溯
        list.remove(list.size() - 1);
    }


    /**
     * 方法二：递归（扩展思路）
     * <p>
     * 思路：
     * 我们也可以讨论几种情况：
     * step 1：如果o1和o2中的任一个和root匹配，那么root就是最近公共祖先。
     * step 2：如果都不匹配，则分别递归左、右子树。
     * step 3：如果有一个节点出现在左子树，并且另一个节点出现在右子树，则root就是最近公共祖先.
     * step 4：如果两个节点都出现在左子树，则说明最低公共祖先在左子树中，否则在右子树。
     * step 5：继续递归左、右子树，直到遇到step1或者step3的情况。
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        //该子树没找到，返回-1
        if (root == null)
            return -1;
        //该节点是其中某一个节点
        if (root.val == o1 || root.val == o2)
            return root.val;
        //左子树寻找公共祖先
        int left = lowestCommonAncestor(root.left, o1, o2);
        //右子树寻找公共祖先
        int right = lowestCommonAncestor(root.right, o1, o2);
        //左子树为没找到，则在右子树中
        if (left == -1)
            return right;
        //右子树没找到，则在左子树中
        if (right == -1)
            return left;
        //否则是当前节点
        return root.val;
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

        int lowestCommonAncestor = new Solution_BM38_在二叉树中找到两个节点的最近公共祖先().lowestCommonAncestor(root, 7, 7);
        System.out.println("lowestCommonAncestor = " + lowestCommonAncestor);


    }


}



