package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */

/**
 * 希尔排序：是插入排序的升级版本，解决了插入排序慢的问题，每次可以将逆序对数量减少大于1
 * <p>
 * 希尔排序使用插入排序对间隔h的序列进行排序，通过不断减少h，最后令h=1，就可以使得整个数组是有序的
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h)
                    SortUtil.exch(a, j - h, j);
            }
            h = h / 3;
        }

    }
}
