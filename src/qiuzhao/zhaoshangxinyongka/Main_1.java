package qiuzhao.zhaoshangxinyongka;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/16.
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strg = scanner.nextLine().trim().split(" ");
        String[] strs = scanner.nextLine().trim().split(" ");
        int[] g = new int[strg.length];
        int[] s = new int[strs.length];
        for (int i = 0; i < strg.length; i++)
            g[i] = Integer.parseInt(strg[i]);

        for (int i = 0; i < strs.length; i++)
            s[i] = Integer.parseInt(strs[i]);

        System.out.println(contentChildren(g, s));
    }

    public static int contentChildren(int[] g, int[] s) {
        int contentNUM = 0;
        Arrays.sort(g);
        for (int j = g.length - 1; j >= 0; j--) {
            for (int i = 0; i < s.length; i++) {
                if (g[j] <= s[i]) {
                    contentNUM++;
                    s[i] = 0;
                    break;
                }
            }
        }
        return contentNUM;
    }
}
