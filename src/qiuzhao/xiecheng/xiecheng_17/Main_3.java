package qiuzhao.xiecheng.xiecheng_17;

/**
 * Created by Huangsky on 2018/9/4.
 */

import java.util.Arrays;
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

    public static int getFirstNotNegative(int[] A) {

        if (A == null) {
            return 0;
        }
        Arrays.sort(A);
        int num = -1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] != 1) {   //先找出第一个缺的正整数
                if (A[i - 1] + 1 > 0) {   //保证A[i-1]大于等于0
                    num = A[i - 1] + 1;   //记录下第一个缺的正整数
                    break;
                }
            }
        }
        if (num == -1) {   //说明在头尾
            if (A[0] > 1) {
                num = A[0] - 1;
            } else {
                num = A[A.length - 1] + 1;
            }
            if (A[A.length - 1] < 0) {
                num = 1;
            }
        }
        return num;


    }

}
