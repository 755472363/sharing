package com.hyk.arithmetic;

import java.util.Stack;

/**
 * NC76 用两个栈实现队列
 */
public class Solution_NC76 {
    /**
     * 描述
     * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
     * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
     * <p>
     * 数据范围： n\le1000n≤1000
     * 要求：存储n个元素的空间复杂度为 O(n)O(n) ，插入与删除的时间复杂度都是 O(1)O(1)
     * <p>
     * 示例1
     * 输入：["PSH1","PSH2","POP","POP"]
     * 返回值：1,2
     * 说明：
     * "PSH1":代表将1插入队列尾部
     * "PSH2":代表将2插入队列尾部
     * "POP“:代表删除一个元素，先进先出=>返回1
     * "POP“:代表删除一个元素，先进先出=>返回2
     * <p>
     * 示例2
     * 输入：["PSH2","POP","PSH1","POP"]
     * 返回值：2,1
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution_NC76 nc76 = new Solution_NC76();

        nc76.push(1);
        nc76.push(2);
        System.out.println(nc76.pop());
        nc76.push(3);
        System.out.println(nc76.pop());
        System.out.println(nc76.pop());

        System.out.println("===========");

        for (int i = 0; i < 5; i++) {
            nc76.push(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(nc76.pop() + " ");
        }
    }

}


