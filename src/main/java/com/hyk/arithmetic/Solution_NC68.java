package com.hyk.arithmetic;

import java.util.HashMap;

/**
 * NC68 跳台阶
 */
public class Solution_NC68 {
    /**
     * 描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * <p>
     * 数据范围：1 \leq n \leq 401≤n≤40
     * 要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
     * <p>
     * 示例1
     * 输入：2
     * 返回值：2
     * 说明：青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为2
     * <p>
     * 示例2
     * 输入：7
     * 返回值：21
     */

    /**
     * 方法一：递归 题目分析，假设f[i]表示在第i个台阶上可能的方法数。逆向思维。如果我从第n个台阶进行下台阶，
     * 下一步有2中可能，一种走到第n-1个台阶，一种是走到第n-2个台阶。
     * 所以f[n] = f[n-1] + f[n-2]. 那么初始条件了，f[0] = f[1] = 1。
     * ==============（疑问？？？：为啥f[0]=1，其中f[2]=f[1]+f[0]，f[2]=2,f[1]=1,所以f[0]=1 ）
     * 所以就变成了：f[n] = f[n-1] + f[n-2], 初始值f[0]=1, f[1]=1，
     * 目标求f[n] 看到公式很亲切，代码秒秒钟写完。
     * <p>
     * 优点，代码简单好写，
     * 缺点：慢，会超时 时间复杂度：O(2^n) 空间复杂度：递归栈的空间
     */
    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 记忆化搜索 拿求f[5] 举例
     * f(5)
     * f(4)                     f(3)
     * f(3)         f(2)        f(2)        f(1)
     * f(2)         f(1)f(0)    f(1)f(0)
     * f(1)f(0)
     * 通过图会发现，方法一中，存在很多重复计算(比如：f(3),f(2)重复计算)，因为为了改进，就把计算过的保存下来。
     * 那么用什么保存呢？一般会想到map
     */
    HashMap<Integer, Integer> map = new HashMap<>();

    public int jumpFloor2(int target) {
        if (target <= 1) {
            return 1;
        }
        if (map.get(target) != null && map.get(target) > 0) {
            return map.get(target);
        }
        int num = jumpFloor2(target - 1) + jumpFloor2(target - 2);
        map.put(target, num);
        return num;
    }

    /**
     * 动态规划
     * 直接从子树求得答案。过程是从下往上
     * f(0)= 1 , f(1) = 1
     * f(2) = f(1) + f(0)
     * f(3) = f(2) + f(1)
     * f(4) = f(3) + f(2)
     * ...
     * f(n) = f(n-1) + f(n-2)
     * <p>
     * 只需要三个变量即可：
     * a = 1, b = 1, c = 1
     * c0 = a + b;
     * c1 = c0 + a   (b = a  a = c0    c1 = a + b)
     * c2 = c1 + c0  (b = c0 a = c1    c2 = a + b)
     * c3 = c2 + c1
     */
    public int jumpFloor3(int target) {
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= target; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }

    /**
     * 斐波那契公式
     */
    public int jumpFloor4(int n) {
        double sqrt = Math.sqrt(5);
        return (int) ((Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1)) / sqrt);
    }

    public static void main(String[] args) {
        Solution_NC68 nc68 = new Solution_NC68();
        System.out.println("====" + nc68.jumpFloor(7));
        System.out.println("====" + nc68.jumpFloor2(7));
        System.out.println("====" + nc68.jumpFloor3(7));
        System.out.println("====" + nc68.jumpFloor4(7));
    }

}


