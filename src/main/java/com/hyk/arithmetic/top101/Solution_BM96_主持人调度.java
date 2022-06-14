package com.hyk.arithmetic.top101;

import java.util.Arrays;

/**
 * BM96 主持人调度（二）
 */
public class Solution_BM96_主持人调度 {
    /**
     * 描述
     * 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,
     * 第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
     *
     * 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，
     * 换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。
     * 求为了成功举办这 n 个活动，最少需要多少名主持人。
     *
     * 复杂度要求：时间复杂度 O(n \log n)O(nlogn) ，空间复杂度 O(n)O(n)
     *
     * 示例1
     * 输入：2,[[1,2],[2,3]]
     * 返回值：1
     * 说明：只需要一个主持人就能成功举办这两个活动
     * 示例2
     * 输入：2,[[1,3],[2,4]]
     * 返回值：2
     * 说明：需要两个主持人才能成功举办这两个活动
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     * <p>
     * 贪心算法，可以拿到解，但不一定是最优解。
     */

    /**
     * 解法1：循环遍历
     * 对活动开始时间进行排序
     * 对活动结束时间进行排序
     * starts[start] >= ends[end]时end++;
     * 否则count++即需要增加一个主持人
     * <p>
     * 理解：
     * 遍历出来，所有活动，同一个时间点，重叠最多的值，即是需要的最少主持人数。
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        int[] starts = new int[startEnd.length];
        int[] ends = new int[startEnd.length];
        for (int i = 0; i < startEnd.length; i++) {
            starts[i] = startEnd[i][0];
            ends[i] = startEnd[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int end = 0;
        for (int start = 0; start < startEnd.length; start++) {
            if (starts[start] >= ends[end]) {
                end++;
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * //0-1--3-4--6-7--9-10
     * //  1--3 4--6 7--9
     * //       4--6
     * 开始：0，1，4，4，7
     * 结束：3，6，6，9，10
     */
    public static void main(String[] args) {
        int[][] startEnd = {{1, 10}, {1, 3}, {4, 6}, {4, 6}, {7, 9}};
        int count = new Solution_BM96_主持人调度().minmumNumberOfHost(startEnd.length, startEnd);
        System.out.println("count = " + count);
    }

}



