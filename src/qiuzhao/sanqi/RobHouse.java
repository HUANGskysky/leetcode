package qiuzhao.sanqi;

import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/6.
 */
public class RobHouse {

    public static int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        //a为上一次的收益
        int a = nums[0];
        //b为当前的收益
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            value[i] = input.nextInt();
        }
        System.out.println("最大价值：" + rob(value));
    }


}
