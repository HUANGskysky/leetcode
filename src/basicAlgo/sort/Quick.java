package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/9/8.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序是一种分治的排序算法，
 * 它将数组分成两个子数组，
 * 将两部分独立的排序
 */
public class Quick {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);   //切分
        sort(a, lo, j - 1);           //将左半部分排序
        sort(a, j + 1, hi);          //将右半部分排序
    }


    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;                //左右扫描的指针
        int j = hi + 1;
        Comparable v = a[i];       //切分的元素
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);            //a[lo...j-1]<=a[j]<=a[j+1...hi]达成
        return j;

    }

    public static boolean less(Comparable a, Comparable b) {   //判断两个元素的大小
        return a.compareTo(b) < 0 ? true : false;
    }

    public static void exch(Comparable[] a, int i, int j) {   //交换
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Comparable[] a = in.nextLine().trim().split(" ");
        System.out.println("快排前：" + Arrays.toString(a));
        sort(a);
        System.out.println("快排后：" + Arrays.toString(a));
    }


}
