package qiuzhao.iqiyi;

/**
 * Created by Huangsky on 2018/9/28.
 */

import java.util.Map;
import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 清雨又在吃自助餐了。
 * 排在清雨面前的有N种食物，排成一排，清雨可以选择其中的若干种食物，但是不能连续选择相邻的食物。因为清雨很挑食，当所有食物都不合口味时，他可以一种都不选，即一个都不选也算为一种方法。
 * 请问他有多少种选择食物的方法呢？
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(getCount(N));

    }

    public static int getCount(int N) {
        int res = N + 1;
        for (int i = 2; i <= Math.ceil(N / 2.0); i++) {
            res += getCount(N - i + 1, i);
        }
        return res;
    }

    public static int getCount(int N, int m) {
        return A(N) / (A(m) * A(N - m));

    }

    public static int A(int up) {
        int result = 1;
        for (int i = up; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
