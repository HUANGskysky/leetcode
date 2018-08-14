package qiuzhao.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/8/14.
 */
public class ShortCut {
    public static ArrayList<String> arr = new ArrayList<String>();
    public static ArrayList<Integer> dat = new ArrayList<Integer>();
    public static int total = 0;

    public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(String[] str, int st, int len) {
        if (st == len - 1) {
            String val = "";
            for (int i = 0; i < len; i++) {

                val += str[i];
                if (i == len - 1) {
                    continue;
                }
                val = val + "-";
            }
            arr.add(val);
            total++;
        } else {
            for (int i = st; i < len; i++) {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }
    }

    /*
        返回的是两个点之间的距离
     */
    public static int calTwoPoint(String x, String y) {
        String[] _x = x.split(",");
        String[] _y = y.split(",");
        return Math.abs(Integer.valueOf(_x[0]) - Integer.valueOf(_y[0])) + Math.abs(Integer.valueOf(_x[1]) - Integer.valueOf(_y[1]));
    }

    public static void calculate(ArrayList<String> _dat, HashMap<String, String> _hm) {
        for (int i = 0; i < _dat.size(); i++) { //分别计算每个距离
            String _buf = _dat.get(i);
            //计算距离
            int sum = 0;
            String[] _ar = _buf.split("-");
            for (int j = 0; j < _ar.length - 1; j++) {
                sum = sum + calTwoPoint(_hm.get(_ar[j]), _hm.get(_ar[j + 1]));
            }
            sum = sum + calTwoPoint("0,0", _hm.get(_ar[0]));
            sum = sum + calTwoPoint("0,0", _hm.get(_ar[_ar.length - 1]));
            dat.add(sum);
        }
        //输出最小
        System.out.println(Collections.min(dat));
    }

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        int number = Integer.valueOf(input.nextLine());
        for (int i = 0; i < number; i++) {
            String v = input.nextLine();
            hm.put(String.valueOf(i + 1), v);
        }
        String[] str = new String[number];
        for (int i = 0; i < number; i++) {
            str[i] = String.valueOf(i + 1);
        }
        Long start = System.currentTimeMillis();
        arrange(str, 0, str.length);
        calculate(arr, hm);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


