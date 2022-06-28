package com.hyk.arithmetic;

import java.util.Arrays;
import java.util.List;

/**
 * NC181 单词拆分(一)
 */
public class Solution_NC181_单词拆分_1 {
    /**
     * 描述
     * 给定一个字符串和一个字符串数组，在字符串的任意位置拆分任意次后得到的字符串集合是否是给定字符串数组的子集。
     *
     * 数据范围：字符串长度满足 1≤len≤500，数组长度满足 1≤n≤1000，数组中字符串长度满足 1≤len≤20
     * 示例1
     * 输入："nowcoder",["now","coder"]
     * 返回值：true
     *
     * 示例2
     * 输入："nowcoder",["no","wcod","der"]
     * 返回值：false
     *
     * 示例3
     * 输入："nowcodernow",["now","coder"]
     * 返回值：true
     */

    /**
     * 字节面试题
     * 我自己的思路，快慢指针，测试通过O(n)
     */
    public boolean wordDiv(String s, String[] dic) {
        if (s == null || dic == null) return false;
        int fast = 0;
        int slow = 0;
        boolean res = false;
        List<String> dicList = Arrays.asList(dic);
        while (fast <= s.length()) {
            String subStr = s.substring(slow, fast);
            if (!dicList.contains(subStr)) {
                fast++;
            } else {
                slow = fast;
                fast++;
                res = true;
            }
        }
        // 如果结果是true，最后指针应该重叠，因为快指针最后又加1，所以相差1，且res恒等于true，即返回true
        if (fast - 1 == slow && res) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String s = "nowcoder";
        String[] str = {"now", "coder"};
        boolean res = new Solution_NC181_单词拆分_1().wordDiv(s, str);
        // true
        System.out.println("res = " + res);

        String s2 = "nowcoder";
        String[] str2 = {"no", "wcod", "der"};
        boolean res2 = new Solution_NC181_单词拆分_1().wordDiv(s2, str2);
        // false
        System.out.println("res2 = " + res2);

    }


}


