package com.hyk.arithmetic;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 字节面试题
 * 多叉树中和为某一值的路径
 */
public class Solution_NC8_2_多叉树中和为某一值的路径_2 {

    /**
     * 给定值num ，找到从根节点到叶子节点，所有节点值相加等于num的路径。节点值可能为负数。
     */

    /**
     * dfs深度优先遍历，回溯法
     * 多叉树中和为某一值的路径
     */
    List<List<Node<Integer>>> res = new ArrayList<>();
    LinkedList<Node<Integer>> path = new LinkedList<>();

    public List<List<Node<Integer>>> getPathByNum(Node<Integer> root, int num) {
        dfs(root, num);
        return res;
    }

    private void dfs(Node<Integer> root, int num) {
        if (root == null) return;
        path.add(root);
        num -= root.val;
        if (root.children == null && num == 0) {
            res.add(new ArrayList<>(path));
        } else {
            List<Node<Integer>> children = root.children;
            if (children != null) {
                for (Node<Integer> child : children) {
                    dfs(child, num);
                }
            }
        }
        path.removeLast();
    }


    /**
     * 多叉树结构
     * ---------0
     * --1------2----------3
     * -4-5-----6-------7-8-9-10
     * 测试6
     * ---------0
     * --1------2----------3
     * -4-5----6-4------7-8-9-10-3
     */
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(0);
        List<Node<Integer>> rootChildren = new ArrayList<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        rootChildren.add(node1);
        rootChildren.add(node2);
        rootChildren.add(node3);
        root.children = rootChildren;

        List<Node<Integer>> node1Children = new ArrayList<>();
        node1Children.add(new Node<>(4));
        node1Children.add(new Node<>(5));
        node1.children = node1Children;

        List<Node<Integer>> node2Children = new ArrayList<>();
        node2Children.add(new Node<>(6));
        node2Children.add(new Node<>(4));
        node2.children = node2Children;

        List<Node<Integer>> node3Children = new ArrayList<>();
        node3Children.add(new Node<>(7));
        node3Children.add(new Node<>(8));
        node3Children.add(new Node<>(9));
        node3Children.add(new Node<>(10));
        node3Children.add(new Node<>(3));
        node3.children = node3Children;

        List<List<Node<Integer>>> res = new Solution_NC8_2_多叉树中和为某一值的路径_2().getPathByNum(root, 6);
        for (List<Node<Integer>> re : res) {
            StringBuilder sb = new StringBuilder();
            for (Node<Integer> integerNode : re) {
                sb.append(integerNode.val).append(" ");
            }
            System.out.println("re= " + sb.toString());
        }

    }
}




