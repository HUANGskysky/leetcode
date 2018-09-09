package qiuzhao.byteDance;

import java.util.Scanner;


/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int[][] arr = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


        System.out.println(resignDepartment(arr));
    }

    public static int resignDepartment(int[][] arr) {
        if (arr == null)
            return 0;
        int count = 0;
        int M = arr.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    continueOne(arr, i, j);   //递归地查找附近的连通的1
                    count++;
                }
            }
        }
        return count;
    }

    public static void continueOne(int[][] arr, int i, int j) {   //利用图像处理中求连通域的思想
        arr[i][j] = 4;   //防止arr[i][j]再次被递归
        if (i < arr.length - 1 && arr[i + 1][j] == 1)      //当arr[i+1][j]==1
            continueOne(arr, i + 1, j);
        if (i > 0 && arr[i - 1][j] == 1)                   //当arr[i-1][j]==1
            continueOne(arr, i - 1, j);
        if (j < arr[i].length - 1 && arr[i][j + 1] == 1) //当arr[i][j+1]==1
            continueOne(arr, i, j + 1);
        if (j > 0 && arr[i][j - 1] == 1)           //当arr[i][j-1]==1
            continueOne(arr, i, j - 1);

    }


}

/*class One{
    private int x;
    private int y;
    public One(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}*/
