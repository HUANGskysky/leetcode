package qiuzhao.wangyi.wangyi_18;

/**
 * Created by Huangsky on 2018/9/8.
 */

import java.util.Scanner;


/**
 * Created by Huangsky on 2018/9/8.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        int[][] possibility = valueSituation(arr);
        for (int i = 0; i < possibility.length; i++) {
            System.out.println(possibility[i][0] + " " + possibility[i][1]);
        }
    }

    public static int[][] valueSituation(int[][] arr) {

        int[][] possibility = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //最小可能性
            //最大可能性
            if (arr[i][0] == arr[i][1] || arr[i][1] == 0)
                possibility[i][0] = possibility[i][1] = 0;
            else if (arr[i][0] - arr[i][1] == 1) {
                possibility[i][0] = 0;
                possibility[i][1] = 1;
            } else {
                possibility[i][0] = 0;
                possibility[i][1] = arr[i][0] - arr[i][1];
            }
        }
        return possibility;
    }

}
