package com.hyk.arithmetic;

/**
 * NC128 接雨水问题
 */
public class Solution_NC128_接雨水问题 {
    /**
     * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0)
     *
     * 示例1
     * 输入：[3,1,2,5,2,4]
     * 返回值：5
     * 说明：数组 [3,1,2,5,2,4] 表示柱子高度图，在这种情况下，可以接 5个单位的雨水，蓝色的为雨水 ，如下图。
     *
     *       5
     *       4 - 4
     * 3 - - 3 - 3
     * 2 - 2 2 2 2
     * 1 1 1 1 1 1
     */

    /**
     * 方法：双指针(推荐使用)
     * 具体做法：
     * step 1：检查数组是否为空的特殊情况
     * step 2：准备双指针，分别指向数组首尾元素，代表最初的两个边界
     * step 3：指针往中间遍历，遇到更低柱子就是底，用较短的边界减去底就是这一列的接水量，遇到更高的柱子就是新的边界，更新边界大小。
     */
    public long maxWater(int[] arr) {
        if (arr.length == 0) return 0;

        // 左右双指针
        int left = 0;
        int right = arr.length - 1;
        long res = 0;
        // 中间区域的边界高度
        int maxL = 0;
        int maxR = 0;
        while (left < right) {
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);
            if (maxL < maxR) {
                res += maxL - arr[left];
                left++;
            } else {
                res += maxR - arr[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 2, 4};
        long res = new Solution_NC128_接雨水问题().maxWater(arr);
        System.out.println("res = " + res);
    }

}


