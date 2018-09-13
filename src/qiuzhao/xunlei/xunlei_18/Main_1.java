package qiuzhao.xunlei.xunlei_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/12.
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
