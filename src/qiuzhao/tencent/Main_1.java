package qiuzhao.tencent;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/16.
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(lcm(n));
    }

    public static int lcm(int n) {
        int i = n + 1;
        int iNUM = n + 1;//记录两个数的最小公倍数
        int j = 1;
        int jNUM = j;
        for (j = 1; j < n; j++) {   //先行计算[1,2,3,...n]的最小公约数
            jNUM = myTwoNumLCM(jNUM, j + 1, hcf(j + 1, jNUM));
        }
        while (true) {
            jNUM = myTwoNumLCM(jNUM, j + 1, hcf(j + 1, jNUM));
            iNUM = myTwoNumLCM(iNUM, i, hcf(i, iNUM));
            if (iNUM == jNUM) {
                break;
            }
            System.out.println(i + "---" + j);
            i++;
            j++;
        }
        return i;

    }

    public static int myTwoNumLCM(int a, int b, int h) {   //根据两个数的最大公约数求两个数的小公倍数
        return (a * b / h);
    }

    public static int hcf(int u, int v) {   //求两个数的最大公约数

        int temp;
        if (u < v) {  //若u小于v，则交换，始终保证u>=v
            temp = u;
            u = v;
            v = temp;
        }
        while (v != 0) {
            temp = u % v;
            u = v;
            v = temp;
        }
        return u;
    }
}
