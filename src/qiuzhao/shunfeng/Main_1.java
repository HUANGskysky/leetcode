package qiuzhao.shunfeng;

import java.util.*;

/**
 * Created by Huangsky on 2018/9/15.
 */

/**
 * 题目：求一个字符串的最长的双节棍字符串
 * 双节棍字符串定义为：aabcc（栗子），三个不用的字符，第一个字符的数量要和第三个字符的数量要相等，并且第一个字符的数量和第三个字符的数量和大于第二个字符数量
 * 输入：字符串
 * 输出：最长的双节棍字符串（如果一个字符串含有多个相等的最长双节棍字符串，则输出第一个）
 * <p>
 * <p>
 * 栗子：
 * 输入：aabcce
 * 输出：aabcc
 * <p>
 * <p>
 * 输入：aabcccdeeeeffgggg
 * 输出：eeeeffgggg
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(isShuangjiegun(str));
    }

    public static String isShuangjiegun(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        boolean flag = false;  //标记位，跳出两层循环
        boolean flag2 = false;  //标记位，指示i的递增方式，如果

        for (; i < str.length(); ) {  // i指针指代双节棍字符串的开头
            flag = false;
            for (; j < str.length(); ) {   //j指针查找输入的每个字符
                if (detailCheck(str.substring(i, j + 1))) {   //将输入字符串的[i,j+1)的子字符串检测其是双节棍字符串
                    result.add(str.substring(i, j + 1));     //若是则添加进result
                    for (; j >= 1; j--) {                      //当前指针j回溯至双节棍字符串的第三个字符的开头
                        // （存在bug，可能需要回到第二个字符的开头,如情况aabbbccddd，输出应该为bbbccddd,而该算法输出aabbbcc）
                        if (str.charAt(j) == str.charAt(j - 1)) {
                            continue;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag == true) {
                    flag2 = true;
                    i = j;
                    break;
                }
                j++;

            }
            if (flag2 == true) {
                flag2 = false;
                continue;
            }
            i++;
        }
        //遍历，找出最长的双节棍字符串
        if (result.size() == 0)
            return null;
        String maxStr = result.get(0);
        for (String s : result) {
            if (s.length() > maxStr.length())
                maxStr = s;
        }
        return maxStr;
    }

    public static boolean detailCheck(String str) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        if (map.size() != 3)
            return false;

        Iterator iterator = map.entrySet().iterator();
        int[] a = new int[3];
        int i = 0;

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> it = (Map.Entry<Character, Integer>) iterator.next();
            a[i++] = it.getValue();
        }


        if (a[0] + a[2] > a[1] && a[0] == a[2])
            return true;
        return false;
    }
}
