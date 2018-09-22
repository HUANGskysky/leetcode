package qiuzhao.byteDance.second;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/20.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        char[][] ch = new char[M][N];
        for (int i = 0; i < M; i++) {
            String[] str = scanner.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                ch[i][j] = str[j].charAt(0);
            }
        }

        findEnglishWord(ch, input);

    }

    public static void findEnglishWord(char[][] ch, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            findWord(ch, strs[i]);
        }
    }

    public static void findWord(char[][] ch, String str) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                if (ch[i][j] == str.charAt(0)) {
                    if (str.length() == erase(ch, i, j, str, 0))
                        System.out.println(str);
                }
            }
        }
    }

    public static int erase(char[][] ch, int i, int j, String str, int index) {

        if (index >= str.length())
            return str.length();

        while (i - 1 >= 0 && (index + 1 < str.length()) && ch[i - 1][j] == str.charAt(index + 1)) {
            return erase(ch, i - 1, j, str, index + 2);
        }

        while (i + 1 < ch.length && (index + 1 < str.length()) && ch[i + 1][j] == str.charAt(index + 1)) {
            return erase(ch, i + 1, j, str, index + 2);
        }

        while (j - 1 >= 0 && (index + 1 < str.length()) && ch[i][j - 1] == str.charAt(index + 1)) {
            return erase(ch, i, j - 1, str, index + 2);
        }

        while (j + 1 < ch[0].length && (index + 1 < str.length()) && ch[i][j + 1] == str.charAt(index + 1)) {
            return erase(ch, i, j + 1, str, index + 2);
        }
        return index;

    }
}
