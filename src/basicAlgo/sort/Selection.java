package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */

/**
 * 选择排序：每次查找出最小的元素和当前元素交换
 */
public class Selection {

    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortUtil.less(a[j], a[min]))
                    min = j;
            }
            if (min != i)
                SortUtil.exch(a, min, i);
        }
    }

}
