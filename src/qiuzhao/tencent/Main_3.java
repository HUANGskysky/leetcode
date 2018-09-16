package qiuzhao.tencent;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/16.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] abc = new int[t][3];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 3; j++) {
                abc[i][j] = scanner.nextInt();
            }

        }
        for (int i = 0; i < t; i++) {
            isYes(abc[i][0], abc[i][1], abc[i][2]);
        }

    }

    public static void isYes(int a, int b, int c) {
        for (int i = 1; i < 1000; i++) {
            if ((i * a) % b == c) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
