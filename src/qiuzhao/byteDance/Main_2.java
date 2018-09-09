package qiuzhao.byteDance;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int[][] arr = new int[M][M];
        for (int i = 0; i < M; i++) {
            String[] strArr = scanner.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        System.out.println(resignDepartment(arr));
    }

    public static int resignDepartment(int[][] arr) {

        if (arr == null)
            return 0;
        int M = arr.length;


        return 0;

    }

}
