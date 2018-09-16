package qiuzhao.zhaoshangxinyongka;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/16.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(jump(n));
    }

    public static int jump(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;


    }
}
