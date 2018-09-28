package JVM.classLoading;

/**
 * Created by Huangsky on 2018/9/22.
 */
public class NotInitialization {
    public static void main(String[] args) {


        /**
         * 被动引用类字段演示一：
         * 通过子类引用父类的静态字段，不会导致子类初始化
         */
//        System.out.println(SubClass.value);

        /**
         * 被动引用类字段演示二：
         * 通过数组定义来引用类，不会触发此类的初始化
         */
//        SuperClass[] classes = new SuperClass[10];


        /**
         * 被动引用使用类字段三：
         * 常量在编译阶段存入调用类的常量池中，本质上并没有直接引用到定义常量的类中，因此不会触发定义常量的类的初始化
         */

        System.out.println(ConstClass.HELLOWORlD);

    }
}
