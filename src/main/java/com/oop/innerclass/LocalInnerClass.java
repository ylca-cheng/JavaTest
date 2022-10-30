package com.oop.innerclass;

/**
 * 内部类学习(成员内部类、局部内部类、匿名内部类、静态内部类)
 * <p>
 * 局部内部类:
 * 局部内部类和成员内部类的区别是它所处的位置与其不同，局部内部类犹如局部变量，
 * 它是在一个方法中，或在一个局部的代码块中去定义一个内部类。
 *
 * 局部内部类的特点如下：
 *
 * 局部内部类只在它的作用域中被实例化，不能使用外部类对象去实例化。
 *
 * 局部内部类不能使用private、public等权限修饰，因为它不属于外部类的成员。
 *
 * 局部内部可以访问外部类对象的成员，并拥有外部类对象的引用。
 *
 * 局部内部类只允许使用作用域内的final常量。
 */
public class LocalInnerClass {
    public int field1 = 1;
    protected int field2 = 2;
    int field3 = 3;
    private int field4 = 4;

    public LocalInnerClass() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    }

    private void localLocalInnerClass() {
        // 局部内部类 A，只能在当前方法中使用
        class A {
            // static int field = 1; // 编译错误！局部内部类中不能定义 static 字段
            public A() {
                System.out.println("创建 " + A.class.getSimpleName() + " 对象");
                System.out.println("其外部类的 field1 字段的值为: " + field1);
                System.out.println("其外部类的 field2 字段的值为: " + field2);
                System.out.println("其外部类的 field3 字段的值为: " + field3);
                System.out.println("其外部类的 field4 字段的值为: " + field4);
            }
        }
        A a = new A();
        if (true) {
            // 局部内部类 B，只能在当前代码块中使用
            class B {
                public B() {
                    System.out.println("创建 " + B.class.getSimpleName() + " 对象");
                    System.out.println("其外部类的 field1 字段的值为: " + field1);
                    System.out.println("其外部类的 field2 字段的值为: " + field2);
                    System.out.println("其外部类的 field3 字段的值为: " + field3);
                    System.out.println("其外部类的 field4 字段的值为: " + field4);
                }
            }
            B b = new B();
        }
//        B b1 = new B(); // 编译错误！不在类 B 的定义域内，找不到类 B，
    }

    /**
     * 同样的，在局部内部类里面可以访问外部类对象的所有访问权限的字段，
     * 而外部类却不能访问局部内部类中定义的字段，因为局部内部类的定义只在其特定的方法体 / 代码块中有效，
     * 一旦出了这个定义域，那么其定义就失效了，就像代码注释中描述的那样，即外部类不能获取局部内部类的对象，
     * 因而无法访问局部内部类的字段。
     *
     * @param args
     */
    public static void main(String[] args) {
        LocalInnerClass outObj = new LocalInnerClass();
        outObj.localLocalInnerClass();
    }
}
