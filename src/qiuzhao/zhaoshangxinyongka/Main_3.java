package qiuzhao.zhaoshangxinyongka;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/16.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(goodNum(N));
    }

    public static int goodNum(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i))
                res++;
        }
        return res;
    }

    public static boolean isGoodNum(int n) {
        String strN = String.valueOf(n);
        if ((strN.contains("2") || strN.contains("5") || strN.contains("6") || strN.contains("9")) && (!strN.contains("3") && (!strN.contains("4")) && (!strN.contains("7"))))
            return true;
        else
            return false;
    }
}
