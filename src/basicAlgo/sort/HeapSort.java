package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */
public class HeapSort {
    /**
     * 数组第 0 个位置不能有元素
     */
    public static void sort(Comparable[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 0; k--)
            sink(nums, k, N);

        while (N > 1) {
            SortUtil.exch(nums, 0, N--);
            sink(nums, 0, N);
        }
    }

    private static void sink(Comparable[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            SortUtil.exch(nums, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] nums, int i, int j) {
        return SortUtil.less(nums[i], nums[j]);
    }
}