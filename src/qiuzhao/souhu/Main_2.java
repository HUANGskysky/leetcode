package qiuzhao.souhu;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/13.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//输入整数，表示需要达到的目标点
        N = Math.abs(N);
        System.out.println(countMove(N));  //输出最小的移动次数

    }

    public static int countMove(int N) {   //计算移动次数
        int k = 0, s = 0;
        int temp = 0;
        while (s < N) {
            k += 1;
            s += k;

        }
        temp = N - s;
        if (temp % 2 == 0) {
            return k;

        } else {
            if (k % 2 == 0) {
                return k + 1;

            } else {
                return k + 2;
            }
        }
    }
}
