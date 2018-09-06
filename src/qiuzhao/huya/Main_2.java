package qiuzhao.huya;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/6.
 */
public class Main_2 {
    public static void encode(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            switch (value) {
                case 1:
                    a[i] = 5;
                    break;
                case 2:
                    a[i] = 3;
                    break;
                case 3:
                    a[i] = 1;
                    break;
                case 4:
                    a[i] = 2;
                    break;
                case 5:
                    a[i] = 4;
                    break;
                default:
                    break;
            }
        }

    }

    public static int[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String[] t1 = in.nextLine().split(" ");
            int[] t2 = new int[t1.length];
            for (int i = 0; i < t1.length; i++) {
                t2[i] = Integer.parseInt(t1[i]);
            }
            return t2;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = parseSampleInput();
        System.out.println("加密前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        encode(a);
        System.out.println("加密后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }
}
