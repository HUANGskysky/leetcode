package qiuzhao.pingduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/21.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] shop = new int[n];
        MyCheap[] cheap = new MyCheap[m];
        for (int i = 0; i < n; i++)
            shop[i] = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            cheap[i] = new MyCheap(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(getMoney(cheap, shop));
    }

    public static int getMoney(MyCheap[] cheap, int[] shop) {

        Arrays.sort(cheap, new Comparator<MyCheap>() {
            @Override
            public int compare(MyCheap o1, MyCheap o2) {
                return o2.getX() - o1.getX();
            }
        });
        for (int i = 0; i < cheap.length; i++)
            System.out.println(cheap[i].getX() + "--" + cheap[i].getY());
        int res = 0;
        for (int i = 0; i < shop.length; i++) {
            res += shop[i];
            for (int j = 0; j < cheap.length; j++) {
                if (shop[i] >= cheap[j].getX()) {
                    res -= cheap[j].getY();
                    break;
                }
            }
        }

        return res;
    }
}


class MyCheap {

    private int x;
    private int y;


    public MyCheap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

}
