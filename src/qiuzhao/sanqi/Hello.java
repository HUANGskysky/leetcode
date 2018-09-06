package qiuzhao.sanqi;

/**
 * Created by Huangsky on 2018/9/6.
 */
public class Hello {
    public static void main(String[] args) {
        A a = new B();
        a.hello();
        B b = new C();
        b.hello();
    }
}

class A {
    public void hello() {
        hello2();
    }

    public void hello2() {
        System.out.println("I ");
    }
}

class B extends A {
    public void hello() {
        super.hello();
    }

    public void hello2() {
        System.out.println("Love ");
    }
}

class C extends B {
    public void hello() {
        super.hello();
    }

    public void hello2() {
        System.out.println("You");
    }
}
