package com.hyk.arithmetic.top101;

import java.util.Arrays;

/**
 * BM96 分糖果问题
 */
public class Solution_BM95 {
    /**
     * 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
     * 1. 每个孩子不管得分多少，起码分到一个糖果。
     * 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
     * 给定一个数组 arrarr 代表得分数组，请返回最少需要多少糖果。
     *
     * 思路：
     * 得分：8 9 2 3 4 7 3 1 8 
     * 糖果：1 1 1 1 1 1 1 1 1
     * 遍历：1 2 1 2 3 4 1 1 2
     * 遍历：1 2 1 2 3 4 2 1 2
     *
     * 正确：1 2 1 2 3 4 2 1 2
     */

    /**
     * pick candy
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     * <p>
     * 事例1：
     * 输入：[1,1,2]
     * 返回值：4
     * 示例2
     * 输入：[1,1,1]
     * 返回值：3
     */
    public int candy(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                candy[i + 1] = candy[i] + 1;
            } else {
                candy[i + 1] = 1;
            }
        }
        System.out.println("糖果 = " + Arrays.toString(candy));
        // 如果左边在上一轮中分到的糖果数更少，则更新为右边糖果数+1，否则保持不变。
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                if (candy[i] < candy[i - 1]) {
                    continue;
                } else {
                    candy[i - 1] = candy[i] + 1;
                }
            }
        }
        System.out.println("糖果 = " + Arrays.toString(candy));
        int candyCount = 0;
        for (int i = 0; i < candy.length; i++) {
            candyCount += candy[i];
        }
        return candyCount;
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 2, 3, 4, 7, 3, 1, 8};
        System.out.println("得分 = " + Arrays.toString(arr));
        int candyCount = new Solution_BM95().candy(arr);
        System.out.println("candyCount = " + candyCount);

        int[] arr2 = {10, 4, 10, 10, 4};
        System.out.println("得分 = " + Arrays.toString(arr2));
        int candyCount2 = new Solution_BM95().candy(arr2);
        System.out.println("candyCount2 = " + candyCount2);
    }

}



