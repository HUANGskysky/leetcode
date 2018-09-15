package qiuzhao.wangyihuyu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/15.
 */
public class Main_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[][] X = new double[4][2];
        double[] Y = new double[4];
        for (int i = 0; i < 4; i++) {
            String[] str = scanner.nextLine().trim().split(",");
            for (int j = 0; j < str.length - 1; j++) {
                X[i][j] = Double.valueOf(str[j]);
            }

            Y[i] = Double.valueOf(str[str.length - 1]);
        }


       /* double[][] X = {{1.0,1.0},{2.0,2.0},{1.0,3.0},{1.0,6.0}};
        double[] y = {3.5,6.5,5.5,4.0};*/
        int n = X[0].length;
        double[] K = new double[n + 1];
        int m = X.length;
        LineRegression(X, Y, K, n, m);
        DecimalFormat df = new DecimalFormat("0.00");
        for (double i : K) {
            System.out.println(df.format(i - 0.005));
        }
    }

    public static double LineRegression(
            double[][] X,
            double[] Y,
            double[] K,
            int n,
            int m
    ) {
        double result = 0;

        /*
        *线性回归问题，最终转换为解一个对称线性方程组的求解问题
        *线性方程组的系数矩阵为n+1*n+1,常数矩阵为n+1*1
        */
        int XLen = n + 1;
        int YLen = 1;
        int i, j, k;
        double[][] coeffX = new double[XLen][XLen];
        double[][] constY = new double[XLen][1];
        double[][] resultK = new double[XLen][1];

        /*
        *根据参数，计算所要求解方程组的系数矩阵、常数矩阵
        */
        double[][] temp = new double[m + 1][n + 1];
        for (i = 0; i < n + 1; i++) {
            temp[0][i] = 1;
        }
        for (i = 0; i < m + 1; i++) {
            temp[i][0] = 1;
        }
        for (i = 1; i < m + 1; i++)
            for (j = 1; j < n + 1; j++)
                temp[i][j] = X[i - 1][j - 1];
        /*
        *开始计算每一个系数
        */
        for (i = 0; i < n + 1; i++) {
            /*
            *coeffX的第i行和i列的系数，注意，是对称矩阵
            */
            for (j = i; j < n + 1; j++) {
                double col = 0;
                for (k = 1; k < m + 1; k++)
                    col += (temp[k][i] * temp[k][j]);
                coeffX[i][j] = col;
                coeffX[j][i] = col;
            }

            /*
            *constY的第i个元素
            */
            double conTemp = 0;
            for (k = 1; k < m + 1; k++)
                conTemp += (Y[k - 1] * temp[k][i]);
            constY[i][0] = conTemp;

        }

        /*
        *调用Sequation方法，解线性方程组
        */

        result = Sequation.guassEquation(coeffX, constY, resultK, XLen, 1);
        if (result == 0) {
            //System.out.println("The regression is failed,please check the sample point \n");
            return result;
        } else {
            for (i = 0; i < n + 1; i++)
                K[i] = resultK[i][0];
        }
        return result;
    }
}

class Sequation {
    public Sequation() {
    }

    /***********************************************************************
     *简要说明：全选主元高斯消元法
     *功能：解线性方程组
     *    @return double abs  矩阵coeffA的行列式,如果abs=0，比较复杂，本函数不作处理,认为没有希望得到的解当|coeffA|=0,可能有无穷多解
     **********************************************************************/
    public static double guassEquation(double[][] coeffA, double[][] constB, double[][] resultX, int n, int m) {
        int i, j, k, row, line;
        double temp, max, abs = 1;
        /*
        *change用于记载系数矩阵列交换的信息
        */
        int[] change = new int[n];
        for (i = 0; i < n; i++) change[i] = i;
        /*
        *从矩阵的第一行开始
        *a、找主元
        *b、行列互换
        *c、线性变换
        */
        for (i = 0; i < n - 1; i++) {
            /*
            *找主元
            */
            row = i;
            line = i;
            max = Math.abs(coeffA[i][i]);
            for (j = i; j < n; j++) {
                for (k = i; k < n; k++) {
                    temp = Math.abs(coeffA[j][k]);
                    if (temp > max) {
                        max = temp;
                        row = j;
                        line = k;

                    }

                }
            }
            /*
            *主元找到了为第row行，第line列，值为max
            *如果max＝0 ，表示行列式为0，返回0，退出
            */
            if (max == 0) {
                return 0;
            }
            /*
            *第二步，行列互换，准备先行变换
            */
            if (row != i) {
                for (k = i; k < n; k++) {
                    temp = coeffA[i][k];
                    coeffA[i][k] = coeffA[row][k];
                    coeffA[row][k] = temp;
                }
                for (k = 0; k < m; k++) {
                    temp = constB[i][k];
                    constB[i][k] = constB[row][k];
                    constB[row][k] = temp;
                }
            }

            if (line != i) {
                for (j = 0; j < n; j++) {
                    temp = coeffA[j][line];
                    coeffA[j][line] = coeffA[j][i];
                    coeffA[j][i] = temp;
                }
                /*
                *记载变量位置的变化（列变换信息标识了变量位置的变化信息）
                */
                k = change[i];
                change[i] = change[line];
                change[line] = k;
            }

            /*
            *开始线性变换,先对第i行归一化，然后对余行线性变换
            */
            abs *= coeffA[i][i];
            for (k = i + 1; k < n; k++) coeffA[i][k] /= coeffA[i][i];
            for (k = 0; k < m; k++) constB[i][k] /= coeffA[i][i];
            coeffA[i][i] = 1;

            /*
            *余矩阵变换
            */
            for (j = i + 1; j < n; j++) {
                for (k = i + 1; k < n; k++) coeffA[j][k] -= coeffA[j][i] * coeffA[i][k];
                for (k = 0; k < m; k++) constB[j][k] -= coeffA[j][i] * constB[i][k];
                coeffA[j][i] = 0;

            }

        }
        abs *= coeffA[n - 1][n - 1];

        /*
        *回代消元
        */
        for (k = 0; k < m; k++) {
            constB[n - 1][k] /= coeffA[n - 1][n - 1];
            for (i = n - 2; i >= 0; i--)
                for (j = i + 1; j < n; j++)
                    constB[i][k] -= coeffA[i][j] * constB[j][k];
        }

        /*
        *根据change，调整变量顺序，得最后解
        */
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                resultX[change[i]][j] = constB[i][j];
            }
        }
        return abs;
    }
}
