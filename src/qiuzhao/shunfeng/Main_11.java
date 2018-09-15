package qiuzhao.shunfeng;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/15.
 */

public class Main_11 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String maxString = null;
        char[] cArray = str.toCharArray();

        int maxlen = 0;


        for (int i = 0; i < cArray.length - 1; i++) {

            int len1 = 1, len2 = 1, len3 = 1;
            if (cArray[i] == cArray[i + 1]) {
                len1++;
                int j = i + 1;
                while (j + 1 < cArray.length) {
                    if (cArray[j] == cArray[j + 1]) {
                        j++;
                        len1++;
                    } else break;
                }

                while (j + 2 < cArray.length) {
                    if (cArray[j + 1] == cArray[j + 2]) {
                        j++;
                        len2++;
                    } else break;
                }

                while (j + 3 < cArray.length) {
                    if (cArray[j + 2] == cArray[j + 3]) {
                        j++;
                        len3++;
                    } else break;
                }

            }

            if (len1 == len3 && len1 > len2 && (len1 + len2 + len3) > maxlen) {
                maxlen = len1 + len2 + len3;
                maxString = str.substring(i, i + maxlen);
            }

        }


        if (maxlen == 0) System.out.println("NULL");
        else System.out.println(maxString);


    }


}