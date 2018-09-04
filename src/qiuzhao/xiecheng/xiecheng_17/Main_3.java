package qiuzhao.xiecheng.xiecheng_17;

/**
 * Created by Huangsky on 2018/9/4.
 */

import java.util.Scanner;

/**
 * 题目：输入一个数组元素个数，找出第一个缺失的非负整数
 * 输入：5
 * -1
 * 1
 * 3
 * 5
 * 6
 */
public class Main_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //处理输入的两个数组
        int len = input.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(getFirstNotNegative(arr));
    }

    public static int getFirstNotNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                continue;
        }

        return 0;
    }

}
