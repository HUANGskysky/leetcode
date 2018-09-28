package JVM.jongdong;

/**
 * Created by Huangsky on 2018/9/22.
 */
public class JDTest {
    public static void main(String[] args) {
        System.out.print(Test.a);
    }
}

class Test {
    public static final String a = "JD";

    static {
        System.out.print("OK");
    }
}
