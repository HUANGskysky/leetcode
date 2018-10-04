package basicAlgo.sort;

/**
 * Created by Huangsky on 2018/10/4.
 */
public class Merge {

    private static Comparable[] aux;   //归并所需要的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];   //一次性分配空间
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           //将左半部分排序
        sort(a, mid + 1, hi);     //将右半部分排序
        merge(a, lo, mid, hi);      //将排好序的左右两部分数组归并
    }

    public static void merge(Comparable[] a, int l, int m, int h) {
        //将a[lo..m]和a[m+1..h]归并
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++)  //将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        for (int k = l; k <= h; k++) {  //归并到a[lo..hi]
            if (i > m)
                a[k] = aux[j++];
            else if (j > h)
                a[k] = aux[i++];
            else if (SortUtil.less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

}
