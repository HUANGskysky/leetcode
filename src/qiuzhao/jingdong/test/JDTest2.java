package qiuzhao.jingdong.test;

/**
 * Created by Huangsky on 2018/9/21.
 */
public class JDTest2 {
    public static void main(String[] args) {
        System.out.print(TestJD.a);
    }
}

class TestJD {
    public static final String a = "JD";

    static {
        System.out.print("OK");
    }
}
