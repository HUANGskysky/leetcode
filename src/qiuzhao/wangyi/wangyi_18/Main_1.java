package qiuzhao.wangyi.wangyi_18;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/8.
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int len = countMaxLength(str);
        System.out.println(len);
    }

    public static int countMaxLength(String str) {
        if (str.length() < 1 || str == null)
            return 0;
        if (str.length() == 1)
            return 1;
        int bLen = 0;
        int wLen = 0;
        char ch = '0';
        for (int i = 0; i < str.length(); i++) {   //计算黑白模块的个数
            ch = str.charAt(i);
            switch (ch) {
                case 'b':
                    bLen++;
                    break;
                case 'w':
                    wLen++;
                    break;
                default:
                    break;
            }
        }
        if (bLen == wLen)
            return bLen << 1;
        else if (bLen - wLen == 1 || wLen - bLen == 1)
            return bLen + wLen;
        return bLen < wLen ? bLen + bLen + 1 : wLen * 2 + 1;
    }

}
