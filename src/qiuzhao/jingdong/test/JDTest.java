package qiuzhao.jingdong.test;

/**
 * Created by Huangsky on 2018/9/21.
 */
public class JDTest {
    public static void main(String[] args) {
        System.out.print(Test.a);
    }
}

class Test {
    static String a = "JD";

    static {
        System.out.print("OK");
    }
}
