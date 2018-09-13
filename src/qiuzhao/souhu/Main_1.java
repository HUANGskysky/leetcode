package qiuzhao.souhu;

import java.util.*;

/**
 * Created by Huangsky on 2018/9/13.
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
