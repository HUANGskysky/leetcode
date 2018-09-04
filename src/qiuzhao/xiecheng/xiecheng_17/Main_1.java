package qiuzhao.xiecheng.xiecheng_17;

/**
 * Created by Huangsky on 2018/9/4.
 */

import java.util.*;

/**
 * [1] 删除字符串中重复字符
 * <p>
 * 题目大意：
 * <p>
 * 输入字符串（未给长度限制），要求删除重复出现的字符（保留第一个）
 * <p>
 * 如：
 * <p>
 * 输入： Hello World
 * 输出：Helo Wrd
 * <p>
 * 内存限制：65536KB
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(deleteRepChar(input));

    }

    public static String deleteRepChar(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        StringBuffer builder = new StringBuffer();
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
        }


        return builder.toString();
    }

}
