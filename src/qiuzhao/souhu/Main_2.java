package qiuzhao.souhu;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/13.
 */

/**
 * 作者：WAK
 * 链接：https://www.nowcoder.com/discuss/108802
 * 来源：牛客网
 * <p>
 * 2题
 * 计算移动次数
 * 无限长的x轴，从坐标0开始，每次向左或向右移动，第n次移动就移动n
 * 问移动到目的点的最少移动次数
 * AC
 * 思路：1~k最大可以得到（1+k)*k/2；将n转为正数，因为n与-n的次数相同，只是镜像取正负；
 * 使得（1+k）*k/2>=n，则（1+k）*k/2-n得到的是小于（1+k）*k/2的正数，若减完后是偶数x，
 * 则可以通过调整1~k中若干个数ai+aj+ak+al....=x/2,将相应的+号转为-号，即可实现将结果-x，
 * 也就是最小的移动次数
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
