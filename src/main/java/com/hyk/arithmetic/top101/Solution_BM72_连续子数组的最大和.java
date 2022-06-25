package com.hyk.arithmetic.top101;

/**
 * BM72 连续子数组的最大和
 */
public class Solution_BM72_连续子数组的最大和 {

    /**
     * 描述
     * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
     * 数据范围:
     * 1 <= n <= 2*10^5
     * −100<=a[i]<=100
     * 要求:时间复杂度为 O(n)，空间复杂度为 O(n)
     * 进阶:时间复杂度为 O(n)，空间复杂度为 O(1)
     */

    /**
     * 方法一：动态规划(推荐使用)
     * 思路：
     * 因为数组中有正有负有0，因此每次遇到一个数，要不要将其加入我们所求的连续子数组里面，是个问题，有可能加入了会更大，有可能加入了会更小，而且我们要求连续的最大值，因此这类有状态转移的问题可以考虑动态规划。
     * <p>
     * 具体做法：
     * step 1：可以用dp数组表示以下标i为终点的最大连续子数组和。
     * step 2：遍历数组，每次遇到一个新的数组元素，连续的子数组要么加上变得更大，要么这个元素本身就更大，要么会更小，更小我们就舍弃，
     * 因此状态转移为dp[i]=max(dp[i−1]+array[i],array[i])。
     * step 3：因为连续数组可能会断掉，每一段只能得到该段最大值，因此我们需要维护一个最大值。
     */

    // 时间复杂度：O(n)
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) return 0;
        // 下标i为终点的最大连续子数组和。
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 思路：
     * 我们注意到方法一的动态规划在状态转移的时候只用到了i−1的信息，没有使用整个辅助数组的信息，因此可以将数组优化掉。
     * <p>
     * step 1：我们可以使用两个变量迭代来代替数组。
     * step 2：状态转移的时候更新变量y，该轮循环结束的再更新x为y即可做到每次迭代都是上一轮的dp。
     * step 3：遍历数组，每次只要比较取最大值即可。
     */
    // 时间复杂度：O(1)
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null) return 0;
        int x = array[0]; // 相当于i-1
        int y = 0;  // 相当于i
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            y = Math.max(x + array[i], array[i]);
            max = Math.max(max, y);
            x = y;
        }
        return max;
    }

    /**
     *
     */
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int res1 = new Solution_BM72_连续子数组的最大和().FindGreatestSumOfSubArray2(arr);
        // 18
        System.out.println("res1 = " + res1);

        int[] arr2 = {2};
        int res2 = new Solution_BM72_连续子数组的最大和().FindGreatestSumOfSubArray2(arr2);
        // 2
        System.out.println("res1 = " + res2);
    }

}



