package qiuzhao.byteDance;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine().trim();
        System.out.println(checkError(ip));
    }

    public static int checkError(String str) {
        int len = str.length();
        if (len < 4 || len > 16)
            return 0;
        HashSet hashSet = new HashSet();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k > 4)
                        continue;
                    int s1 = Integer.parseInt(str.substring(0, i));
                    int s2 = Integer.parseInt(str.substring(i, j));
                    int s3 = Integer.parseInt(str.substring(j, k));
                    int s4 = Integer.parseInt(str.substring(k));

                    if (s1 > 255 || s2 > 255 || s3 > 255 || s4 > 255)
                        continue;
                    String ip = s1 + "." + s2 + "." + s3 + "." + s4 + ".";
                    if (ip.length() < len + 3)
                        continue;
                    hashSet.add(ip);


                }
            }
        }
        return hashSet.size();
    }
}
