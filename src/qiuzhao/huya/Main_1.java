package qiuzhao.huya;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/6.
 */
public class Main_1 {

    public static void order(String[] a) {
        for (int i = 0; i < a.length; i++) {

        }

    }

    public static String[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            return in.nextLine().split(" ");
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = parseSampleInput();
        order(a);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
