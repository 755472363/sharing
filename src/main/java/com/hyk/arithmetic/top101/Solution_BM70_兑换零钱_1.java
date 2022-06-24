package com.hyk.arithmetic.top101;

import java.util.Arrays;

/**
 * BM70 兑换零钱(一)
 */
public class Solution_BM70_兑换零钱_1 {

    /**
     * 描述
     * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
     * 如果无解，请返回-1.
     *
     * 数据范围：数组大小满足 0≤n≤10000 ， 数组中每个数字都满足 0<val≤10000，0≤aim≤5000
     * 要求：时间复杂度 O(n×aim) ，空间复杂度 O(aim)。
     *
     * 示例1
     * 输入：[5,2,3],20
     * 返回值：4
     *
     * 示例2
     * 输入：[5,2,3],0
     * 返回值：0
     *
     * 示例3
     * 输入：[3,5],2
     * 返回值：-1
     */

    /**
     * 方法一：动态规划（推荐使用）
     * 思路：
     * 这类涉及状态转移的题目，可以考虑动态规划。
     * <p>
     * 具体做法：
     * step 1：可以用dp[i]表示要凑出i元钱需要最小的货币数。
     * step 2：一开始都设置为最大值aim+1aim+1aim+1，因此货币最小1元，即货币数不会超过aimaimaim.
     * step 3：初始化dp[0]=0。
     * step 4：后续遍历1元到aim元，枚举每种面值的货币都可能组成的情况，取每次的最小值即可，转移方程为dp[i]=min(dp[i],dp[i−arr[j]]+1).
     * step 5：最后比较dp[aim]的值是否超过aim，如果超过说明无解，否则返回即可。
     */
    public int minMoney(int[] arr, int aim) {
        // aim等于0，不叫无解，最少张数就是0，而非-1，无法兑换的叫无解返回-1
        if (aim == 0) return 0;
        // dp[i]表示要凑出i元钱需要最小的货币数（为啥aim+1：看main方法解释，aim=3，凑足3元最少张数，即dp[3]，dp[3]长度至少是4 = 3+1，即aim+1）
        int[] dp = new int[aim + 1];
        //初始化为最大值，最终无解，则dp[aim] = aim + 1 > aim 返回-1
        Arrays.fill(dp, aim + 1);
        //总金额为0的时候所需钱币数一定是0
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {// 遍历目标值
            for (int j = 0; j < arr.length; j++) {// 遍历钱币
                if (arr[j] <= i) {//如果当前的钱币比目标值小就可以兑换
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];
    }

    public static void main(String[] args) {
        // 解释为啥是要dp数组长度，要target+1       int[] dp = new int[target + 1];
        // 要凑3块钱
        int target = 3;
        // 3代表数组种有3个元素，length = 3
        int[] dp = new int[target + 1];
        dp[0] = 0;
        //dp[3] 表示凑足3元，最小张数，dp[3]，所需长度是4；


        int[] arr = {5, 8};
        int aim = 20;

        int res1 = new Solution_BM70_兑换零钱_1().minMoney(arr, aim);
        System.out.println("res1 = " + res1);
    }

}



