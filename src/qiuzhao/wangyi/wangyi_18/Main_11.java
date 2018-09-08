package qiuzhao.wangyi.wangyi_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/8.
 */
public class Main_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int len = countMaxLength(str);
        System.out.println(len);
    }

    public static int countMaxLength(String str) {

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            int j = i;
            while (j + 1 < str.length() && str.charAt(j + 1) != str.charAt(j)) {
                count++;
                j++;

            }
            count++;
            if (max < count)
                max = count;
        }
        return max;
    }
}
