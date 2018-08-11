package qiuzhao.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {


        String str = (String) PermutationWithDictionary();
        System.out.println(str);


    }

    public static int jieCheng(int n) {
        int pro = 1;
        while (n > 0) {
            pro *= n;
            n--;
        }
        return pro;
    }

    public static String PermutationWithDictionary() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int m = Integer.parseInt(in.next());
        int k = Integer.parseInt(in.next());
        int num = jieCheng(m + n) / (jieCheng(n) * jieCheng(m));
        if (num < k)
            return "-1";


        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        for (int i = 0; i < m; i++) {
            sb.append('z');
        }
        char[] chs = sb.toString().toCharArray();

        Arrays.sort(chs);
        //先对数组的元素进行依次排序
        int ii = 0;
        while (true) {
            ii++;
            if (ii == k) {
                       /* System.out.println(chs);*/
                return String.valueOf(chs);
            }
            int j = chs.length - 1;
            int index = 0;
            for (j = chs.length - 2; j >= 0; j--) {
                if (chs[j] < chs[j + 1]) {
                    index = j;
                    break;
                    //从右向左找到第一个非递增的元素
                } else if (j == 0) {
                    return "-1";
                }
            }

            for (j = chs.length - 1; j >= 0; j--) {
                if (chs[j] > chs[index])
                    break;
                //从右向左找到第一个比非递增元素大的元素
            }
            Swap(chs, index, j);
            //交换找到的两个元素
            Reverse(chs, index + 1);
            //对非递增元素位置后面的数组进行逆序排列
        }
    }

    public static void Reverse(char chs[], int i) {
        int k = i, j = chs.length - 1;
        while (k < j) {
            Swap(chs, k, j);
            k++;
            j--;
        }
    }

    public static void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}