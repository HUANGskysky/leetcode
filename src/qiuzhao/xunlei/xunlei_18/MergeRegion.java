package qiuzhao.xunlei.xunlei_18;

/**
 * Created by Huangsky on 2018/9/12.
 */


import java.util.*;

/**
 * [编程题]合并区间
 * <p>
 * 用x,y表示一个整数范围区间，现在输入一组这样的范围区间(用空格隔开)，请输出这些区间的合并。
 * <p>
 * 输入描述:
 * <p>
 * 一行整数，多个区间用空格隔开。区间的逗号是英文字符。
 * <p>
 * 输出描述:
 * <p>
 * 合并后的区间，用过空格隔开，行末无空格
 * <p>
 * 示例1
 * <p>
 * 输入
 * <p>
 * 1,3 2,5
 * <p>
 * 输出
 * <p>
 * 1,5
 * <p>
 * <p>
 * 示例2
 * <p>
 * 输入
 * <p>
 * 1,3 2,5 8,10 11,15
 * <p>
 * 输出
 * <p>
 * 1,5 8,10 11,15
 */
public class MergeRegion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] region = scanner.nextLine().trim().split(" ");
        ArrayList<Region> list = new ArrayList<Region>();
        int start = 0;
        int end = 0;
        //处理输入
        for (int i = 0; i < region.length; i++) {
            String[] startEnd = region[i].split(",");
            start = Integer.parseInt(startEnd[0]);
            end = Integer.parseInt(startEnd[1]);
            list.add(new Region(start, end));
        }

        List<Region> lists = mergeRegion(list);
        for (Region reg : lists) {
            if (reg != lists.get(lists.size() - 1))
                System.out.print(reg.toString() + " ");
            else
                System.out.println(reg.toString());
        }

    }

    public static List<Region> mergeRegion(ArrayList<Region> list) {

        LinkedList<Region> result = new LinkedList<>();
        Collections.sort(list, new Comparator<Region>() {  //先排序
            @Override
            public int compare(Region o1, Region o2) {
                int i = o1.getStart() - o2.getStart();
                if (i == 0)                                //当两个区间的起始相等时，继续比较区间的结尾
                    return o1.getEnd() - o2.getEnd();
                else
                    return i;
            }
        });


        Region currentRegion;  //指示当前的遍历区间
        Region preRegion;     //结果集存放的最后区间

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {      //先存放第一个区间进去
                result.add(list.get(0));
                continue;
            }
            currentRegion = list.get(i);   //当前遍历的区间
            preRegion = result.getLast();  //取出结果集的最后的区间
            if ((preRegion.getEnd() >= currentRegion.getStart())) {  //当满足结果集区间的结尾大于当前遍历区间的起始
                if (preRegion.getEnd() >= currentRegion.getEnd()) {  //并且结果集区间的结尾大于当前遍历区间的尾部，说明结果集区间包含当前的遍历区间，则跳过
                    continue;
                }
                result.removeLast();                              //否则，移除结果集区间，并新添加范围更大的并集区间
                result.add(new Region(preRegion.getStart(), currentRegion.getEnd()));
            } else {   //当满足结果集区间的结尾小于当前遍历区间的起始，则说明两者没有重叠的区域，添加当前遍历区间进结果集
                result.add(currentRegion);
            }


        }


        return result;
    }
}

/**
 * 存放区间的类
 */
class Region {

    private int start;
    private int end;

    public Region(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String toString() {
        return start + "," + end;
    }
}
