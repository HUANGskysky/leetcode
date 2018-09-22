package qiuzhao.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/21.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        System.out.println(getMinCache(nums));
    }

    public static int getMinCache(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1 || nums.length == 2)
            return 1;
        Arrays.sort(nums);
        int N = 2;
        //    while (true)
        {
            int[] arr = new int[N];
            for (int i = 0; i < nums.length; i++) {
                arr[nums[i] % N]++;
            }
            for (int i = 0; i < N; i++) {

            }
        }

        return 0;

    }
}
