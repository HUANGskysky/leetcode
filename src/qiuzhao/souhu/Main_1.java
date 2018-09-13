package qiuzhao.souhu;

import java.util.*;

/**
 * Created by Huangsky on 2018/9/13.
 */

/**
 * 作者：WAK
 * 链接：https://www.nowcoder.com/discuss/108802
 * 来源：牛客网
 * <p>
 * 1题
 * 兄弟串
 * 通过交换两个字符能得到的串称为兄弟串，判断两个字符串是否为兄弟串
 * AC
 * 思路：判断两个字符串中相同位值不同的个数，将相应位置为*，若=2，则符合要求，
 * 若！=2，则排序，若存在至少两个不为*的相同字符，则也符合要求
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] AB = scanner.nextLine().split(" ");
        String A = AB[0];
        String B = AB[1];

        System.out.println(isBrotherString(A, B));
    }

    public static int isBrotherString(String A, String B) {
        if (A.length() != B.length())
            return 0;
        LinkedList<Character> listA = new LinkedList<>();
        LinkedList<Character> listB = new LinkedList<>();
        someHandle(listA, A);
        someHandle(listB, B);
        Collections.sort(listA, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(listB, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i) != listB.get(i))
                return 0;
        }
        return 1;


    }

    public static void someHandle(LinkedList<Character> list, String str) {
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
    }


}
