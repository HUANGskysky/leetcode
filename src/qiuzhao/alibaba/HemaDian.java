package qiuzhao.alibaba;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.*;
import java.util.List;

/**
 * Created by Huangsky on 2018/9/7.
 */
public class HemaDian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] guangLocation = in.nextLine().split(",");
        Location guang = new Location(Integer.parseInt(guangLocation[0]), Integer.parseInt(guangLocation[1]));
        List<Location> range = new LinkedList<>();
        String[] strLocation = in.nextLine().split(",");
        for (int i = 0; i < strLocation.length - 1; i++) {
            range.add(new Location(Integer.parseInt(strLocation[i]), Integer.parseInt(strLocation[i + 1])));
        }

        int position = isInRange(range, guang);
        if (position != 0) {
            System.out.println("no," + position);
        } else
            System.out.println("yes," + 0);


    }

    public static int isInRange(List<Location> range, Location guang) {
        int juli = Integer.MAX_VALUE;
        GeneralPath p = new GeneralPath();
        Location first = range.get(0);
        p.moveTo(first.getX(), first.getY());
        juli = Math.min(juli, juli(first, guang));
        range.remove(0);
        for (Location location : range) {                       //把所有的点都围起来构造成一个完成的多边形
            p.lineTo(location.getX(), location.getY());
            juli = Math.min(juli, juli(location, guang));
        }
        p.lineTo(first.getX(), first.getY());
        p.closePath();
        return p.contains(new Point(guang.getX(), guang.getY())) ? 0 : juli;       //判断小广的坐标是否位于多边形内
    }

    public static int juli(Location p1, Location P2) {
        int x = p1.getX() - P2.getX();
        int y = p1.getY() - P2.getY();
        return (int) Math.sqrt(x * x + y * y);

    }


}

/**
 * 记录位置信息的类
 */
class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
