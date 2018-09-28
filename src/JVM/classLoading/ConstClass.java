package JVM.classLoading;

/**
 * Created by Huangsky on 2018/9/22.
 */

/**
 * 被动引用使用类字段三：
 * 常量在编译阶段存入调用类的常量池中，本质上并没有直接引用到定义常量的类中，因此不会触发定义常量的类的初始化
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORlD = "hello world";
}
