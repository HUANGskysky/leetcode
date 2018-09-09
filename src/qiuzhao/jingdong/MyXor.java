package qiuzhao.jingdong;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class MyXor {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[2];

        str[0] = scanner.next().trim();
        str[1] = scanner.next().trim();

        System.out.println(myXor(str, n));

    }

    public static int myXor(String[] str, int n) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str[0].charAt(i) == str[1].charAt(i)) {
                if (i != 0)
                    strBuilder.append(0);
            } else {
                strBuilder.append(1);
            }
        }
        return convertToInt(strBuilder.toString());

    }

    public static int convertToInt(String str) {
        int len = str.length();
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                result += Math.pow(2, i);
            }
        }
        return result;
    }


}
