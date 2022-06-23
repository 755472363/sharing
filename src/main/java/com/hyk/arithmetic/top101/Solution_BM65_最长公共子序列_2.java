package com.hyk.arithmetic.top101;

/**
 * BM65 最长公共子序列(二)
 * 有点难，忽略
 */
public class Solution_BM65_最长公共子序列_2 {

    /**
     * 描述：
     * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
     * 要求：空间复杂度 O(n^2),时间复杂度 O(n^2)
     * <p>
     * 示例1
     * 输入："1A2C3D4B56","B1D23A456A"
     * 返回值："123456"
     * <p>
     * 示例2
     * 输入："abc","def"
     * 返回值："-1"
     */

    /**
     * 方法一：动态规划+递归获取（推荐使用）
     */
    public String LCS(String s1, String s2) {
        return null;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";

        String res1 = new Solution_BM65_最长公共子序列_2().LCS(s1, s2);
        System.out.println("res1 = " + res1);

        String res2 = new Solution_BM65_最长公共子序列_2().LCS(s1, s2);
        System.out.println("res2 = " + res2);
    }

}



