package qiuzhao.byteDance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Huangsky on 2018/9/9.
 */
public class Main_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println(findNotRepLength(input));

    }

    /*public static int findNotRepLength(String str){
        if (str == null || str.length() < 1)
            return 0;
        if (str.length() == 1)
            return 1;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0;i<str.length();i++){
            if (!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
            }else{
                set.clear();
                set.add(str.charAt(i));
            }
            maxLen = Math.max(set.size(),maxLen);
        }
        return maxLen;
    }
*/
    public static int findNotRepLength(String str) {
        if (str == null || str.length() < 1)
            return 0;
        if (str.length() == 1)
            return 1;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (!set.contains(str.charAt(j))) {
                    set.add(str.charAt(j));
                } else {
                    break;
                }
            }
            maxLen = Math.max(set.size(), maxLen);
        }
        return maxLen;
    }
}
