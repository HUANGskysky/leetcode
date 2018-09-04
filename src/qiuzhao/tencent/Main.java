package qiuzhao.tencent;

/**
 * Created by Huangsky on 2018/9/3.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int result = preNSum(n, m);
        System.out.println(result);
    }

    public static int preNSum(int n, int m) {
        int result = 0;
        boolean flag = false;
        int i = 1;
        while (i <= n) {
            if (!flag) {
                for (int j = 0; j < m; j++)
                    result = result - i - j;
            } else {
                for (int j = 0; j < m; j++)
                    result = result + i + j;
            }
            i += m;
            flag = !flag;
        }
        return result;
    }
}