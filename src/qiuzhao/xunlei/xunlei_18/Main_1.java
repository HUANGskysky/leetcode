package qiuzhao.xunlei.xunlei_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/12.
 */

/**
 * 作者：zhudky
 * 链接：https://www.nowcoder.com/discuss/108052
 * 来源：牛客网
 * <p>
 * 第一题，有正数A，和负数B，选m个A，n个B排成一排，使：m+n = 17 ,且任意相邻7个数和小于0，问这17个数的最大和是多少？
 * <p>
 * 思路：找出7个数中至少需要几个B，然后按，A...A B...B A..A B...B A...A B...B 排列，取前17个，这样保证后三个尽可能使正数A。最后只过了88%，不知道漏掉了什么情况。【求大佬指点一下】
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(maxSum(A, B));
    }

    public static int maxSum(int a, int b) {
        int n = (int) (a + Math.abs(-b)) / a;
        int m = 17 / n;
        int d = 17 % n;
        int y = 17 - n * m - d + m;
        int x = n * m + d - m;
        return a * x - b * y;


    }
}
