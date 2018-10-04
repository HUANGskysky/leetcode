package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */

/**
 * 插入排序：每次将当前元素插入左侧已经排序的数组中，使得插入之后左侧数据仍然有序
 * <p>
 * 插入排序每次只能交换相邻元素，令逆序数量减1
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && SortUtil.less(a[j], a[j - 1]); j--)
                SortUtil.exch(a, j - 1, j);
        }
    }
}
