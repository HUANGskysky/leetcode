package qiuzhao.xiecheng.xiecheng_18;

/**
 * Created by Huangsky on 2018/9/5.
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/4676515ca9a94841a4121670513aaf6b
 * 来源：牛客网
 */
public class Test {

    public static Test t1 = new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Test t2 = new Test();
    }

}