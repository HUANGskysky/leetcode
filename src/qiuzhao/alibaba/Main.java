package qiuzhao.alibaba;

/**
 * Created by Huangsky on 2018/8/14.
 */

import java.util.Scanner;

/**
 * 计算快递员在各个点送快递最短路径问题:<br>
 * 输入参数例子： <br/>
 * 4<br/>
 * 2,2 <br/>
 * 2,8 <br/>
 * 4,4<br/>
 * 7,2 <br/>
 * 输出应为：30
 *
 * @author Huangsky
 */
public class Main {
    // 快递员起始点
    static final Point START = new Point(0, 0);
    // 记录最短路径，并初始化为无限大
    static int minPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            String[] Location = scanner.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(Location[0]), Integer.parseInt(Location[1]));
        }


        long start = System.currentTimeMillis();
        System.out.println(caculator(points, 0));
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) + "ms");  //测试用时
    }

    /**
     * 用全排列的递归版本解决此问题
     *
     * @param points
     * @param n
     */
    public static int caculator(Point[] points, int n) {
        if (n == points.length) {
            // 计算本次全排列的路径长度
            int sum = points[0].getLength(START);
            for (int i = 1; i < points.length; i++) {
                sum += points[i - 1].getLength(points[i]);
            }
            // 加上到起始点的路径长度
            sum += points[points.length - 1].getLength(START);
            // 记录最短路径长度
            minPath = Math.min(minPath, sum);
            return minPath;
        }
        // 以下进行递归的全排列
        for (int i = n; i < points.length; i++) {
            swap(points, n, i);
            caculator(points, n + 1);//递归
            swap(points, n, i);
        }
        return minPath;
    }

    /**
     * 交换数组的x,y两个值
     *
     * @param points
     * @param x
     * @param y
     */
    public static void swap(Point[] points, int x, int y) {
        if (x == y) {
            return;
        }
        Point temp = points[x];
        points[x] = points[y];
        points[y] = temp;
    }

}


/**
 * 送货地点
 *
 * @author Huangsky
 */
class Point {
    int px;
    int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
    }

    /**
     * 获取与指定点之间的距离
     *
     * @param p
     * @return
     */
    public int getLength(Point p) {
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}
