package qiuzhao.souhu;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/13.
 */

/**
 * 比较版本号大小
 * 判断两个版本号大小
 * AC
 * 思路：将版本号补齐，直接比较字符串的大小
 */
public class Main_33 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        String[] data = temp.split(" ");

        System.out.println(compareVersion(data[0], data[1]));


    }

    public static int compareVersion(String version1, String version2) throws Exception {

        if (version1 == null || version2 == null) {
            throw new Exception("Error input!");
        }

        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
        for (int i = 0; i < versionArray1.length; i++) { //如果位数只有一位则自动补零（防止出现一个是04，一个是5 直接以长度比较）
            if (versionArray1[i].length() == 1) {
                versionArray1[i] = "0" + versionArray1[i];
            }
        }
        String[] versionArray2 = version2.split("\\.");
        for (int i = 0; i < versionArray2.length; i++) {//如果位数只有一位则自动补零
            if (versionArray2[i].length() == 1) {
                versionArray2[i] = "0" + versionArray2[i];
            }
        }
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }

        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return -1;
        }

        return diff;
    }
}
