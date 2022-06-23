package com.hyk.arithmetic.top101;

/**
 * BM66 最长公共子串
 */
public class Solution_BM66_最长公共子串 {

    /**
     * 描述
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
     * 题目保证str1和str2的最长公共子串存在且唯一。
     *
     * 要求： 空间复杂度 O(n^2),时间复杂度 O(n^2)
     *
     * 示例1
     * 输入："1AB2345CD","12345EF"
     * 返回值："2345"
     */

    /**
     * 动态规划（推荐使用）
     * 具体做法：
     * step 1：我们可以用dp[i][j]表示在str1中以第i个字符结尾,在str2中以第j个字符结尾时的公共子串长度，
     * step 2：遍历两个字符串填充dp数组，转移方程为：如果遍历到的该位两个字符相等，则此时长度等于两个前一位长度+1，dp[i][j]=dp[i−1][j−1]+1，
     * 如果遍历到该位时两个字符不相等，则置为0，因为这是子串，必须连续相等，断开要重新开始。
     * step 3：每次更新dp[i][j]后，我们维护最大值，并更新该子串结束位置。
     * step 4：最后根据最大值结束位置即可截取出子串。
     */
    public String LCS(String str1, String str2) {
        //dp[i][j]表示到str1第i个,到str2第j个为止的公共子串长度
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        int pos = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                //如果该两位相同
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    //则增加长度
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    //该位置为0
                    dp[i][j] = 0;
                //更新最大长度
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    pos = i - 1;
                }
            }
        }
        return str1.substring(pos - max + 1, pos + 1);
    }

    /**
     * 荐看这个，好理解一点点
     * 空间复杂度 O(n^2),时间复杂度 O(n^2)
     * <p>
     * 定义dp[i][j]表示字符串str1中第i个字符和str2种第j个字符为最后一个元素所构成的最长公共子串。
     * 如果要求dp[i][j]，也就是str1的第i个字符和str2的第j个字符为最后一个元素所构成的最长公共子串，我们首先需要判断这两个字符是否相等。
     * 如果不相等，那么他们就不能构成公共子串，也就是dp[i][j]=0;
     * 如果相等，我们还需要计算前面相等字符的个数，其实就是dp[i-1][j-1]，所以dp[i][j]=dp[i-1][j-1]+1;
     * 有了递推公式，代码就比较简单了，我们使用两个变量，一个记录最长的公共子串的长度，一个记录最长公共子串的结束位置，最后再对字符串进行截取即可
     */
    public String LCS2(String str1, String str2) {
        int maxLenth = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[i + 1][j + 1] > maxLenth) {
                        maxLenth = dp[i + 1][j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";

//        String res1 = new Solution_BM66_最长公共子串().LCS(s1, s2);
//        System.out.println("res1 = " + res1);

        String res2 = new Solution_BM66_最长公共子串().LCS2(s1, s2);
        System.out.println("res2 = " + res2);
    }

}



