package qiuzhao.liulishuo;

/**
 * Created by Huangsky on 2018/9/17.
 */
public class Main_2 {
    public static void main(String[] args) {
        System.out.println(getMin(100));
    }

    public static int getMin(int total) {
        int x = 1;
        int sum = 0;
        while (sum < total) {
            sum += x;
            x += 1;
        }
        return x - 1; // 返回的是最坏可能下需要扔的次数
    }
}
