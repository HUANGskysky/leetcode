package qiuzhao.byteDance.second;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/20.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = scanner.nextLine().trim().toLowerCase();
        }
    }


}
