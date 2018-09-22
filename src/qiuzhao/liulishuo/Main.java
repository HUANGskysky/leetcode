package qiuzhao.liulishuo;

/**
 * Created by Huangsky on 2018/9/17.
 */
public class Main {
    public static void main(String[] args) {
        splitChange(5);
    }

    //找零钱算法
    public static void splitChange(int change) {
        //输入参数校验
        if (change < 1) {
            System.out.println("Invalid input.");
            return;
        }

        int copy = change;
        //纸币的面值，必须降序排列
        int[] notes = {50, 20, 10, 5, 1};
        //找零所需要的每张纸币的数量
        int[] pieces = new int[notes.length];
        //下面是主要的步骤
        while (change > 0) {
            for (int i = 0; i < notes.length; i++) {
                if (change >= notes[i]) {
                    change = change - notes[i];
                    pieces[i] += 1;
                    break;
                }
            }
        }
        //结果输出
        System.out.print(String.format("Your change is %d,\n%d=", copy, copy));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] > 0)
                sb.append(String.format("%d*%d piece(s)+", notes[i], pieces[i]));
        }
        String msg = sb.toString();
        msg = msg.substring(0, msg.length() - 1);
        System.out.println(msg);
    }
}
