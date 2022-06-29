package com.hyk.arithmetic;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * NC119 最小的K个数
 */
public class Solution_NC119_最小的K个数 {
    /**
     * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     * 数据范围：0≤k,n≤10000，数组中每个数的大小0≤val≤1000
     * 要求：空间复杂度 O(n) ，时间复杂度 O(nlogn)
     * <p>
     * 示例1
     * 输入：[4,5,1,6,2,7,3,8],4
     * 返回值：[1,2,3,4]
     * 说明：返回最小的4个数即可，返回[1,3,2,4]也可以
     * <p>
     * 示例2
     * 输入：[1],0
     * 返回值：[]
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k == 0) return res;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : input) {
            priorityQueue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 6, 2, 7, 3, 8};

        ArrayList<Integer> res = new Solution_NC119_最小的K个数().GetLeastNumbers_Solution(arr1, 4);
        System.out.println("res = " + res.toString());
    }

}



