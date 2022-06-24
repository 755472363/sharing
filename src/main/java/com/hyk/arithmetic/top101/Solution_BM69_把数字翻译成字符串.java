package com.hyk.arithmetic.top101;

import java.util.Arrays;

/**
 * BM69 把数字翻译成字符串
 */
public class Solution_BM69_把数字翻译成字符串 {

    /**
     * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
     * 我们把一个字符串编码成一串数字，再考虑逆向编译成字符串。
     * 由于没有分隔符，数字编码成字母可能有多种编译结果，例如 11 既可以看做是两个 'a' 也可以看做是一个 'k' 。但 10 只可能是 'j' ，因为 0 不能编译成任何结果。
     * 现在给一串数字，返回有多少种可能的译码结果
     *
     * 数据范围：字符串长度满足 0<n≤90
     * 进阶：空间复杂度 O(n)，时间复杂度 O(n)
     */

    /**
     * 方法：动态规划（推荐使用）
     * <p>
     * 思路：
     * 对于普通数组1-9，译码方式只有一种，但是对于11-19，21-26，译码方式有可选择的两种方案，因此我们使用动态规划将两种方案累计。
     * <p>
     * 具体做法：
     * step 1：用辅助数组dp表示前i个数的译码方法有多少种。
     * step 2：对于一个数，我们可以直接译码它，也可以将其与前面的1或者2组合起来译码：如果直接译码，则dp[i]=dp[i−1]；如果组合译码，则dp[i]=dp[i−2]。
     * step 3：对于只有一种译码方式的，选上种dp[i−1]即可，对于满足两种译码方式（10，20不能）则是dp[i−1]+dp[i−2]
     * step 4：依次相加，最后的dp[length]即为所求答案。
     * <p>
     * 特殊情况处理
     * 只有一种编译方式的 dp[i]=dp[i−1]
     * 满足两种编译方式的 dp[i]=dp[i−1]+dp[i−2]  在11-19，21-26之间的情况
     */
    public int solve(String nums) {
        //排除0
        if (nums.equals("0")) return 0;
        //当0的前面不是1或2时，无法译码，0种
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0')
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        if ("10".equals(nums) || "20".equals(nums) || nums.length() == 1) return 1;
        int[] dp = new int[nums.length() + 1];
        // 辅助数组初始化为1
        Arrays.fill(dp, 1);
        for (int i = 2; i <= nums.length(); i++) {
            // 如果 在11-19，21-26之间的情况
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) > '0') || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }

    // 忽略，上边的好理解些
    public int solve2(String nums) {
        //排除0
        if (nums.equals("0")) return 0;
        //当0的前面不是1或2时，无法译码，0种
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0')
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        if ("10".equals(nums) || "20".equals(nums) || nums.length() == 1) return 1;

        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            //  3 2 4
            int num = (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[nums.length() - 1];
    }

    public static void main(String[] args) {
        String s1 = "12";
        String s2 = "31717126241541717";

        int res1 = new Solution_BM69_把数字翻译成字符串().solve2(s1);
        //2
        System.out.println("res1 = " + res1);

        int res2 = new Solution_BM69_把数字翻译成字符串().solve2(s2);
        //192
        System.out.println("res2 = " + res2);
    }

}



