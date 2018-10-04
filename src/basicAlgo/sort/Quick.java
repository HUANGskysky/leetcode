package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/9/8.
 */


/**
 * 快速排序是一种分治的排序算法，
 * 它将数组分成两个子数组，
 * 将两部分独立的排序
 */
public class Quick {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);   //切分
        sort(a, lo, j - 1);           //将左半部分排序
        sort(a, j + 1, hi);          //将右半部分排序
    }


    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;                //左右扫描的指针
        int j = hi + 1;
        Comparable v = a[i];       //切分的元素
        while (true) {
            while (SortUtil.less(a[++i], v)) if (i == hi) break;
            while (SortUtil.less(v, a[--j])) if (j == lo) break;
            if (i >= j)
                break;
            SortUtil.exch(a, i, j);
        }
        SortUtil.exch(a, lo, j);            //a[lo...j-1]<=a[j]<=a[j+1...hi]达成
        return j;

    }
}
