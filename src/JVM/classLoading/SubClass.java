package JVM.classLoading;

/**
 * Created by Huangsky on 2018/9/22.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
