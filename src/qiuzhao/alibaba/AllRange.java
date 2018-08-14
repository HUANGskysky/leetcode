package qiuzhao.alibaba;

import java.util.Arrays;

/**
 * Created by Huangsky on 2018/8/14.
 */

/**
 * 链接：https://blog.csdn.net/lemon_tree12138/article/details/50986990
 * https://blog.csdn.net/LanTingShuXu/article/details/81277306
 * https://blog.csdn.net/yoer77/article/details/53458612
 * 有关全排列的
 */
public class AllRange {
    // 需要被全排列的数组
    private static String[] arr = "a,b,c,d".split(",");

    public static void main(String[] args) {
        rangeAll(arr, 0);
    }

    /**
     * 全排列指定数组
     *
     * @param arr 需要被全排列的数组
     * @param n   记录递归的层数（从0开始）
     */
    public static void rangeAll(String[] arr, int n) {
        if (n == arr.length) {
            // 打印数组
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = n; i < arr.length; i++) {
            swap(arr, n, i);
            rangeAll(arr, n + 1);
            swap(arr, n, i);
        }
    }

    /**
     * 交换数组中指定的两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(String[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}