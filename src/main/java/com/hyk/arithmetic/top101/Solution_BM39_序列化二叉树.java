package com.hyk.arithmetic.top101;


import com.hyk.arithmetic.TreeNode;

/**
 * BM39 序列化二叉树
 */
public class Solution_BM39_序列化二叉树 {

    /**
     * 方法：前序遍历（推荐使用）
     * 思路：
     * 序列化即将二叉树的节点值取出，放入一个字符串中，我们可以按照前序遍历的思路，遍历二叉树每个节点，并将节点值存储在字符串中，我们用‘#’表示空节点，用‘!'表示节点与节点之间的分割。
     * 反序列化即根据给定的字符串，将二叉树重建，因为字符串中的顺序是前序遍历，因此我们重建的时候也是前序遍历，即可还原。
     */
    StringBuilder sb = new StringBuilder();

    String Serialize(TreeNode root) {
        preOrder(root);
        return sb.toString();
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val).append("!");
        Serialize(root.left);
        Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        if ("#".equals(str)) return null;
        return preDeserialize(str);
    }

    int index = 0;

    private TreeNode preDeserialize(String str) {
        //到达叶节点时，构建完毕，返回继续构建父节点
        //空节点
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        //数字转换
        int val = 0;
        //遇到分隔符或者结尾，val可能是大于10的数字
        while (str.charAt(index) != '!' && index != str.length()) {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        //序列到底了，构建完成
        if (index == str.length())
            return root;
        else
            index++;
        //反序列化与序列化一致，都是前序
        root.left = preDeserialize(str);
        root.right = preDeserialize(str);
        return root;
    }


    /**
     * 4
     * 2 6
     * 1 3 5 7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.toString();

        String Serialize = new Solution_BM39_序列化二叉树().Serialize(root);
        System.out.println("Serialize = " + Serialize);
        TreeNode Deserialize = new Solution_BM39_序列化二叉树().Deserialize(Serialize);
        Deserialize.toString();
    }


}



