package easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Huangsky on 2018/8/7.
 */


/**
 * **************《牛客网--剑指offer》*************
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {20, 1, 9, 4, 3, 7, 8, 5, 18, 2};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("before:");
        for (int num : array) {
            System.out.print("->" + num);
            list.add(num);
        }
        System.out.println();
        System.out.println("after:");
        reOrderArray(list);
        for (int num : list) {
            System.out.print("->" + num);
        }
    }

    public static void reOrderArray(ArrayList<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if ((a % 2 == 1) && (b % 2 == 0))
                    return -1;
                if ((a % 2 == 1) && (b % 2 == 1))
                    return 1;
                if ((a % 2 == 0) && (b % 2 == 1))
                    return 1;
                if ((a % 2 == 0) && (b % 2 == 0))
                    return 1;
                else
                    return 1;
            }
        });
    }
}

