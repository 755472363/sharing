package com.hyk.arithmetic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * NC61 两数之和
 */
public class Solution_NC61_两数之和 {

    /**
     * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
     * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
     * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
     */
    public int[] twoSum(int[] numbers, int target) {
        // 值，坐标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (!map.containsKey(temp)) {
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(temp) + 1, i + 1};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 4};
        int[] arr2 = {20, 70, 110, 150};

        int[] res1 = new Solution_NC61_两数之和().twoSum(arr1, 6);
        int[] res2 = new Solution_NC61_两数之和().twoSum(arr2, 90);

        System.out.println("res1 = " + Arrays.toString(res1));
        System.out.println("res2 = " + Arrays.toString(res2));
    }


}



