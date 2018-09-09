package qiuzhao.wangyi.wangyi_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/8.
 */
public class Main_22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            String[] arr = s.split(" ");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            method(n, k);
        }
    }

    public static void method(int n, int k) {

        System.out.print("0 ");
        int c = n - k;
        if (k < 2 || n < 3) {
            System.out.println("0");
            return;
        }
        if (c < k) {
            System.out.println(c);
        } else {
            if (k == c) {
                System.out.println(k - 1);
            }
            System.out.println(k - 1);
        }
    }
}

