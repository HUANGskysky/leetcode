package qiuzhao.huawei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/26.
 */
public class Main_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim().toUpperCase();
        System.out.println(countMaxCharacter(str));


    }

    public static String countMaxCharacter(String str) {
        if (str.length() == 0 || str == null)
            return null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (!Character.isLetter(ch))
                continue;
            if (!map.containsKey(ch))
                map.put(ch, 1);
            else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> it = (Map.Entry<Character, Integer>) iter.next();
            if (max < it.getValue()) {
                max = it.getValue();
            }
        }

        for (Character key : map.keySet()) {
            if (map.get(key) == max) {
                sb.append(key).append(max);
                break;
            }
        }
        return sb.toString();
    }
}
