package qiuzhao.shunfeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/15.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(",");
        int max = scanner.nextInt();
        List<String> list = check(str, max);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

    public static List<String> check(String[] str, int max) {
        List<String> list = new ArrayList<>();
        for (String s : str) {
            list.add(s);
        }
        return list;
    }
}
