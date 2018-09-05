package qiuzhao.xiecheng.xiecheng_18;
/**
 * Created by Huangsky on 2018/9/4.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long num = in.nextLong();
        Long find = in.nextLong();
        HashMap<Long, Mytime> map = new HashMap<Long, Mytime>();
        for (long i = 0; i < num; i++) {
            map.put(in.nextLong(), new Mytime(in.nextLong(), in.nextLong()));
        }
        System.out.println(findOrder(map, find));


    }

    public static Long findOrder(HashMap<Long, Mytime> map, Long find) {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, Mytime> it = (Map.Entry<Long, Mytime>) iter.next();
            Mytime me = it.getValue();
            if (me.getStart() <= find && me.getLeave() >= find) {
                return it.getKey();
            }

        }
        return null;
    }
}

class Mytime {
    private Long start;
    private Long leave;

    public Mytime(Long start, Long leave) {
        this.start = start;
        this.leave = leave;
    }

    public Long getStart() {
        return start;
    }

    public Long getLeave() {
        return leave;
    }

}
