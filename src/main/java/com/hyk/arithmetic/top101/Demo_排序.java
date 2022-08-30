package com.hyk.arithmetic.top101;

import java.util.Arrays;
import java.util.Random;

public class Demo_排序 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(10);
        }
//        System.out.println(Arrays.toString(arr));
//        int[] res = new Demo_排序().MySort(arr);
//        System.out.println(Arrays.toString(res));

        System.out.println(Arrays.toString(arr));
        new Demo_排序().quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * 将给定数组排序
     */
    public int[] MySort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1); //中点位置，即(l+r)/2
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];    //辅助数组
        int i = 0;
        int p1 = l; //左半数组的下标
        int p2 = mid + 1; //右半数组的下标

        //判断是否越界
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1没有越界，说明p2越界了，将左边剩余元素拷贝到辅助数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        //p2没有越界，说明p1越界了
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //将辅助数组元素拷贝会原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /**
     * 快速排序 2022-07-28
     */
    void quickSort(int left, int right, int[] nums) {
        if (left < right) {
            int mid = sort(left, right, nums);
            quickSort(left, mid - 1, nums);
            quickSort(mid + 1, right, nums);
        }
    }

    private int sort(int left, int right, int[] nums) {
        int temp = nums[left];
        // 把所有大于temp的放到右边，小于temp的放到左边
        // 没有这行代码，只交换了一次
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left; // 返回枢纽元素最终位置
    }


    /**
     * 快速排序 2022-08-30
     */
    public int[] MyQuickSortMain2(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 不修改左右边界，赋值给新的变量，改变新变量
            int i = left;
            int j = right;
            // 左边第一个元素当作枢纽
            int temp = arr[i];
            // 没有这行代码，只交换了一次
            while (i < j) {
                // 把所有大于temp的放到右边，小于temp的放到左边
                //  >=相等的，不需要交换
                while (i < j && arr[j] >= temp) j--;
                arr[i] = arr[j];
                //  <=相等的，不需要交换
                while (i < j && arr[i] <= temp) i++;
                arr[j] = arr[i];
            }
            // 枢纽元素，放到最终位置
            arr[i] = temp;
            // 右子集进行排序
            quickSort(arr, i + 1, right);
            // 左子集进行排序
            quickSort(arr, left, i - 1);
        }
    }
}
