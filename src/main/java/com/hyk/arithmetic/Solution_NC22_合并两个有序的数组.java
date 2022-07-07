package com.hyk.arithmetic;

import java.util.Arrays;

/**
 * NC22 合并两个有序的数组
 */
public class Solution_NC22_合并两个有序的数组 {
    /**
     * 描述
     * 给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
     *  注意：
     * 1.保证 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n
     * 2.不要返回合并的数组，将数组 B 的数据合并到 A 里面就好了，且后台会自动将合并后的数组 A 的内容打印出来，所以也不需要自己打印
     * 3. A 数组在[0,m-1]的范围也是有序的
     *
     * 输入：[4,5,6],[1,2,3]
     * 返回值：[1,2,3,4,5,6]
     * 说明：A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，B还是为[1,2,3]，m=3，n=3，
     * 传入到函数merge里面，然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
     */

    /**
     * 一次遍历
     * 参考BM1,代码注解
     */
    public void merge(int A[], int m, int B[], int n) {
        int a = m - 1;
        int b = n - 1;
        for (int i = n + m - 1; i >= 0; i--) {
            if (b < 0 || a >= 0 && A[a] > B[b]) {
                A[i] = A[a];
                a--;
            } else {
                A[i] = B[b];
                b--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 0, 0, 0};
        int[] B = {1, 2, 3};
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("B = " + Arrays.toString(B));
        new Solution_NC22_合并两个有序的数组().merge(A, 3, B, B.length);
        System.out.println("merge A = " + Arrays.toString(A));
    }

}


