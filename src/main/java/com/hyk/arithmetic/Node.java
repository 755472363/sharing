package com.hyk.arithmetic;

import java.util.List;

/**
 * 多叉树 Node 节点
 */
public class Node<T> {
    public int val;
    public List<Node<T>> children;

    public Node(int val) {
        this.val = val;
    }
}
