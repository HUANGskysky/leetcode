package JVM.jongdong;

/**
 * Created by Huangsky on 2018/9/22.
 */
public class JD {
    public static void main(String[] args) {
        System.out.print(Test2.a);
    }
}

class Test2 {
    public static final String a = new String("JD");

    static {
        System.out.print("OK");
    }
}

