package qiuzhao.souhuchangyou;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/15.
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findRep(num));
    }

    public static int findRep(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : num) {
            if (set.contains(i))
                return i;
            else
                set.add(i);
        }

        return 0;
    }
}
