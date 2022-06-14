package com.hyk.arithmetic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * NC93 设计LRU缓存结构
 */
public class Solution_NC93_设计LRU缓存结构 {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     * 输入： [[1,1,1],[1,2,2],[2,1],[1,3,3],[2,2],[1,4,4],[2,1],[2,3],[2,4]],2
     * 返回值：[1,-1,-1,3,4]
     * set和get操作复杂度均为 O(1)O(1)
     */
    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public int[] LRU(int[][] operators, int k) {
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] result = new int[len];
        head.next = tail;
        tail.prev = head;
        int i = 0;
        for (int[] operator : operators) {
            if (operator.length == 3) {
                set(operator[1], operator[2], k);
            } else if (operator.length == 2) {
                result[i] = get(operator[1]);
                i++;
            }
//            check();
        }
        return result;
    }

    public void set(int key, int value, int k) {
        if (get(key) > -1) {
            map.get(key).val = value;
        } else {
            if (map.size() == k) {
                Node remNode = tail.prev;
                int rk = remNode.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                remNode.next = null;
                remNode.prev = null;
                map.remove(rk);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            removeToHead(node);
        }

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            removeToHead(node);
            return node.val;
        }
        return -1;
    }

    public void removeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void check() {
        StringBuilder sb = new StringBuilder();
        Node tempHead = head;
        while (tempHead != null) {
            sb.append(tempHead.key).append(" ");
            tempHead = tempHead.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] opt = {{1, 1, 1}, {1, 2, 2}, {2, 1}, {1, 3, 3}, {2, 2}, {1, 4, 4}, {2, 1}, {2, 3}, {2, 4}};
        int[] res = new Solution_NC93_设计LRU缓存结构().LRU(opt, 2);
        System.out.println(Arrays.toString(res));

        int[][] opt2 = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int[] res2 = new Solution_NC93_设计LRU缓存结构().LRU(opt2, 3);
        System.out.println(Arrays.toString(res2));
    }
}


