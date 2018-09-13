package qiuzhao.xunlei.xunlei_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/12.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  //输入整数
        System.out.println(count(N));  //输出素勾股数个数
    }

    public static int count(int N) {
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(N / 2.0); i++) {
            for (int j = i + 1; j <= (int) Math.sqrt(N / 1.0); j++) {
                if (!(gcd(i, j) == 1 && (i % 2 != j % 2)))   //两个数非互质
                    continue;
                int x = j * j - i * i;
                int y = 2 * j * i;
                int z = i * i + j * j;
                if (z > N)
                    break;
                if (gcd(x, y) == 1 && (gcd(x, z) == 1 && gcd(y, z) == 1)) {  //当满足勾股定理并且均为互质，则count++
                    count++;
                }
            }
        }
        return count;

    }

    public static int gcd(int a, int b) {   //根据欧拉定理判断两个数是否互质
        return b == 0 ? a : gcd(b, a % b);
    }
}
