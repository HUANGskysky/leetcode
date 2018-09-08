package qiuzhao.wangyi.wangyi_17;

import java.util.*;

/**
 * Created by Huangsky on 2018/9/7.
 */


/**
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * <p>
 * <p>
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 * <p>
 * <p>
 * <p>
 * 输入例子1:
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * <p>
 * 输出例子1:
 * 100
 * 1000
 * 1001
 */
public class FindJob {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jobNum = in.nextInt();
        int friendNum = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(friendNum);
        for (int i = 0; i < jobNum; i++) {
            map.put(in.nextInt(), in.nextInt());
        }
        for (int i = 0; i < friendNum; i++) {
            list.add(in.nextInt());
        }

        List<Integer> salary = findJob(map, list);
        for (Integer sal : salary) {
            System.out.println(sal);
        }
    }

    public static List<Integer> findJob(HashMap<Integer, Integer> map, ArrayList<Integer> list) {
        ArrayList<Integer> salary = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            Iterator iter = map.entrySet().iterator();
            salary.add(Integer.MIN_VALUE);
            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> it = (Map.Entry) iter.next();
                Integer difficulty = it.getKey();
                if (difficulty > list.get(i))
                    continue;
                else
                    salary.add(Math.max(salary.remove(i), it.getValue()));
            }
        }


        return salary;
    }


}
