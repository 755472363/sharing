package com.hyk.arithmetic.top101;

/**
 * BM73 最长回文子串
 */
public class Solution_BM73_最长回文子串 {

    /**
     * 描述
     * 对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
     *
     * 数据范围： 1≤n≤1000
     * 要求：空间复杂度 O(1)，时间复杂度 O(n^2)
     * 进阶:  空间复杂度 O(n)，时间复杂度 O(n)
     *
     * 示例1
     * 输入："ababc"
     * 返回值：3
     * 说明：最长的回文子串为"aba"与"bab"，长度都为3
     */

    /**
     * 方法一：中心扩展法（推荐使用）
     * 知识点：贪心思想
     * 思路：
     * 回文串，有着左右对称的特征，从首尾一起访问，遇到的元素都是相同的。但是我们这里正是要找最长的回文串，并不事先知道长度，怎么办？
     * 判断回文的过程是从首尾到中间，那我们找最长回文串可以逆着来，从中间延伸到首尾，这就是中心扩展法。
     * <p>
     * 具体做法：
     * step 1：遍历字符串每个字符。
     * step 2：以每次遍历到的字符为中心（分奇数长度和偶数长度两种情况），不断向两边扩展。
     * step 3：如果两边都是相同的就是回文，不断扩大到最大长度即是以这个字符（或偶数两个）为中心的最长回文子串。
     * step 4：我们比较完每个字符为中心的最长回文子串，取最大值即可。
     */

    //空间复杂度 O(1)，时间复杂度 O(n^2)
    public int getLongestPalindrome(String A) {
        int maxlen = 1;
        //以每个点为中心
        for (int i = 0; i < A.length() - 1; i++)
            //分奇数长度和偶数长度向两边扩展
            maxlen = Math.max(maxlen, Math.max(fun(A, i, i), fun(A, i, i + 1)));
        return maxlen;
    }

    private int fun(String s, int begin, int end) {
        //每个中心点开始扩展
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        // 为啥要-1，ababc 1，1  -> 0,2 长度是3  所以2-0+1   不应该+1吗？
        // 为啥要-1，abaabc 2，3  -> 1,4 长度是4  所以4-1+1  不应该+1吗？
        // 因为满足收尾相等后，又做了一次begin--,end++操作，所以长度应该是end- begin -1，而非+1；
        return end - begin - 1;
    }

    /**
     *
     */
    public static void main(String[] args) {
        String A = "ababc";
        int res1 = new Solution_BM73_最长回文子串().getLongestPalindrome(A);
        // 3
        System.out.println("res1 = " + res1);
    }

}



