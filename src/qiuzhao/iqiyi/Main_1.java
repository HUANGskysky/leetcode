package qiuzhao.iqiyi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * Bob有N个空盒子，第i个盒子是边长为a[i]的立方体，如果一个盒子的边长严格小于另一个盒子，并且大盒子里面没有其他小盒子，
 * 小盒子也没有放入其他大盒子中，那么这个小盒子可以放入大盒子。Bob可以根据条件任意的放盒子，因为他想看见最少数量的盒子。
 * 没有放入其他盒子的盒子是可以被看到的，请你帮Bob确定能看见盒子的最少数量。
 */

/**
 * Created by Huangsky on 2018/9/28.
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getMinBox(arr));
    }

    public static int getMinBox(int[] arr) {
        Arrays.sort(arr);
        int res = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
