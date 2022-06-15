package com.hyk.arithmetic.top101;

import java.util.Arrays;
import java.util.Random;

public class Demo_排序 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        int[] res = new Demo_排序().MySort(arr);
        System.out.println(Arrays.toString(res));
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


}
