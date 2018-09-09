package qiuzhao.jingdong;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        }

        System.out.println(findBadProduct(matrix));
    }

    public static int findBadProduct(int[][] matrix) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // 存在aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
                if ((matrix[j][0] > matrix[i][0]) && (matrix[j][1] > matrix[i][1]) && (matrix[j][2] > matrix[i][2])) {
                    flag = true;
                    break;
                }


            }
            if (flag) {
                count++;
                flag = false;
            }

        }
        return count;
    }
}
