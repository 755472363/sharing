package com.hyk.arithmetic;

import java.util.Arrays;

/**
 * NC140 排序
 */
public class Solution_NC140 {
    /**
     * 给定一个长度为 n 的数组，请你编写一个函数，返回该数组按升序排序后的结果。
     * 数据范围： 0 \le n \le 1\times10^30≤n≤1×10 3
     * ，数组中每个元素都满足 0 \le val \le 10^90≤val≤10 9
     * 要求：时间复杂度 O(n^2)O(n 2)，空间复杂度 O(n)O(n)
     * 进阶：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(n)O(n)
     * 注：本题数据范围允许绝大部分排序算法，请尝试多种排序算法的实现。
     * <p>
     * 示例1
     * 输入：[5,2,3,1,4]
     * 返回值：[1,2,3,4,5]
     * 示例2
     * 输入：[5,1,6,2,5]
     * 返回值：[1,2,5,5,6]
     */


    public int[] MySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int refer = arr[i];
            while (i != j) {
                while (i < j && arr[j] >= refer) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                while (i < j && arr[i] <= refer) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = refer;
            quickSort(arr, left, i - 1);
            quickSort(arr, j + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 1, 4};
        int[] arr2 = {5, 1, 6, 2, 5};
        System.out.println("arr1 = " + Arrays.toString(new Solution_NC140().MySort(arr1)));
        System.out.println("arr2 = " + Arrays.toString(new Solution_NC140().MySort(arr2)));
    }

}



