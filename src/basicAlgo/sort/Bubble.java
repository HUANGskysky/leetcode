package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */

/**
 * 冒泡排序：每次比较相邻的元素，把较大者放于后面
 */
public class Bubble {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (SortUtil.less(a[j + 1], a[j]))
                    SortUtil.exch(a, j + 1, j);
            }
        }
    }
}
