package qiuzhao.sanqi;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/6.
 */
public class Is37Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("是否是37数字：" + is37Number(num));
    }

    public static boolean is37Number(int num) {
        if (num == 1)
            return true;
        if (num % 2 == 0 || num < 0)
            return false;
        while (num % 3 == 0)
            num /= 3;
        while (num % 7 == 0)
            num /= 7;
        if (num == 1)
            return true;
        else
            return false;
    }
}
