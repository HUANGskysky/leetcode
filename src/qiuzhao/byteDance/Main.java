package qiuzhao.byteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/8.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        int count = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int head = in.nextInt();
            int weba = in.nextInt();
            int k = in.nextInt();
            for (int j = head - 1; j < weba; j++) {
                if (arr.get(j) == k) {
                    count++;
                }
            }
            res.add(count);
            count = 0;
        }
        for (int i = 0; i < q; i++) {
            System.out.println(res.get(i));
        }
    }

}

