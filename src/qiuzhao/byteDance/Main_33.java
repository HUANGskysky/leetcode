package qiuzhao.byteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main_33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine().trim();
        System.out.println(checkError(ip));
    }

    public static int checkError(String str) {

        ArrayList<String> result = new ArrayList<>();
        String tmp = new String();
        mySearch(str, tmp, result, 4, 0, str.length());
        return result.size();

    }

    public static void mySearch(String s, String temp, ArrayList<String> result, int count, int index, int len) {
        //index字符串的下标
        //记录Ip的第几位
        if (count == 0 && index == len) {
            result.add(temp);
            return;
        }
        if ((count == 0 && index < len) || (count > 0 && index == len)) {
            return;
        }

        int value = 0;
        boolean flag = true;  //标记第一个字符是否为零

        while (index < len && flag) {
            if (value == 0 && s.charAt(index) == '0') {
                flag = false;
            }
            value = value * 10 + s.charAt(index) - '0';
            index++;
            if (value < 256) {
                String record = "";
                if (count == 1)
                    record = temp + Integer.toString(value);
                else {
                    record = temp + Integer.toString(value) + ".";
                }
                mySearch(s, record, result, count - 1, index, len);
            }
        }

    }
}
