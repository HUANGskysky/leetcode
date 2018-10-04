package basicAlgo.sort;

import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/10/4.
 */
public class SortUtil {

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
        System.out.println("快序前：" + Arrays.toString(a));
        sort(a, "heap");
        System.out.println("排序后：" + Arrays.toString(a));
    }

    public static void sort(Comparable[] a, String method) {
        switch (method) {
            case "select":
                Selection.sort(a);
                break;
            case "bubble":
                Bubble.sort(a);
                break;
            case "insert":
                Insertion.sort(a);
                break;
            case "shell":
                Shell.sort(a);
                break;
            case "merge":
                Merge.sort(a);
                break;
            case "quick":
                Selection.sort(a);
                break;
            case "heap":
                HeapSort.sort(a);
                break;
            default:
                break;
        }
    }
}
