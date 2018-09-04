package qiuzhao.xiecheng.xiecheng_17;

/**
 * Created by Huangsky on 2018/9/4.
 */

import java.util.Scanner;

/**
 * 给定两个数组，要求合并非重复元素并给出合并后数组的中位数
 * 例如输入：
 * 数组1
 * 3
 * 1 2 3
 * 数组2
 * 4
 * 3 4 5 6
 * 得到数组 1 2 3 4 5 6
 * 输出中位数 3.5
 */
public class Main_2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //处理输入的两个数组
        int len1 = input.nextInt();
        int[] arr1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr1[i] = input.nextInt();
        }

        int len2 = input.nextInt();
        int[] arr2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            arr2[i] = input.nextInt();
        }

        System.out.println("中位数：" + getMidFromArray(arr1, arr2));


    }

    public static double getMidFromArray(int[] arr1, int[] arr2) {

        //1. 对两个数组进行整合
        int len = arr1.length + arr2.length;
        int arr[] = new int[len];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < len; i++) {
            if (arr1 == null) {
                arr = arr2;
                break;
            }
            if (arr2 == null) {
                arr = arr1;
                break;
            }

            if (index1 == arr1.length) {   //防止下标越界
                arr[i] = arr2[index2++];

            } else if (index2 == arr2.length) { //防止下标越界
                arr[i] = arr1[index1++];
            } else if ((arr1[index1] > arr2[index2])) {
                arr[i] = arr2[index2];
                index2++;
            } else {
                arr[i] = arr1[index1];
                index1++;
            }

        }

        //对新数组查找中位数
        int mid = len >> 1;
        if (len < 2)
            return arr[0];
        if (len % 2 == 1)
            return (double) arr[mid];
        else
            return (double) (arr[mid - 1] + arr[mid]) / 2;

    }
}
