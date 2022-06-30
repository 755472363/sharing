package com.hyk.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * NC41 最长无重复子数组
 */
public class Solution_NC41_最长无重复子数组 {
    /**
     * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * <p>
     * 示例4
     * 输入：[1,2,3,1,2,3,2,2]
     * 返回值：3
     * 说明：最长子数组为[1,2,3]
     */

    /**
     * 双指针(也可以说是，滑动窗口)
     * 方法：滑动窗口 + 哈希表(推荐使用)
     */
    public int maxLength(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int res = 0;
        // <当前值，出现频次>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < arr.length; right++) {
            if (!map.containsKey(arr[right])) {
                map.put(arr[right], 1);
            } else {
                // 此处为啥不能写死为2，比如：1 4 4 5 6 7 遍历到第2个4时候，key=1已经存在，但是频次已经变成0，加1后是1，不是2
                map.put(arr[right], map.get(arr[right]) + 1);
                // 出现次数大于1，则窗口内有重复
                while (map.get(arr[right]) > 1) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 队列（最好理解）
     * 我们还可以用一个队列，把元素不停的加入到队列中，如果有相同的元素，就把队首的元素移除，这样我们就可以保证队列中永远都没有重复的元素
     */
    public int maxLength2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int res = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i : arr) {
            while (queue.contains(i)) {
                queue.poll();
            }
            queue.offer(i);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    /**
     * 不太好理解
     */
    public int maxLength3(int[] arr) {
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int right = 0, left = 0; right < arr.length; ++right) {
            if (map.containsKey(arr[right])) {
                // 包含，把left更新为，当前值索引+1(这个值可能比较小，比如：1 4 4 1 遍历第二个1，left=3索引可能大于当前索引=0+1=1)和left最大值
                left = Math.max(left, map.get(arr[right]) + 1);
                System.out.println("left = " + left + "," + (map.get(arr[right]) + 1));
            }
            map.put(arr[right], right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 1, 3, 3, 3, 1};
        int[] arr3 = {4, 1, 4, 2, 4, 3, 1, 3, 2, 2};

        int[] arr2 = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextInt(5);
        }

        int res = new Solution_NC41_最长无重复子数组().maxLength3(arr1);
        System.out.println("res = " + res);
    }

}



