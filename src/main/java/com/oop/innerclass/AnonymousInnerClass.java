package com.oop.innerclass;

/**
 * 内部类学习(成员内部类、局部内部类、匿名内部类、静态内部类)
 *
 * 匿名内部类
 * 匿名内部类特点如下：
 *
 * 1）匿名内部类没有名字。
 *
 * 2）匿名内部类没有权限修饰符。
 *
 * 3）匿名内部类由于没有名字所以无法定义构造方法，可用构造代码块实现
 *
 * 4）匿名内部类对象无法通过外部类对象去创建，成员内部类对象可通过外部类对象创建。
 *
 * 5）匿名内部类要么继承父类，要么实现接口，两者不能兼备且只允许直接有一个父类或接口，成员内部类没有限制。
 *
 * 7）匿名内部类可以访问外部类的成员变量及成员方法 。
 *
 * 8）匿名内部类只允许使用作用域内的final常量。
 *
 * 为什么要使用匿名内部类：
 * 当一个方法需要不同的实现来完成功能时就可以使用匿名内部类
 * 例如，有个排序的接口，因为排序的逻辑可能千奇百怪，只有在用的时候才知道要怎么排序，
 * 这时就可以使用匿名内部类，实时的实现接口，做到自定义排序逻辑。
 *
 * 匿名内部类有多种形式，其中最常见的一种形式莫过于在方法参数中新建一个接口对象 / 类对象，并且实现这个接口声明 / 类中原有的方法了
 *
 * 为什么叫匿名内部类，这是因为jvm会自动帮你创建一个匿名的类去实现接口或继承对应的类或抽象类
 *
 * 1、直接 new 一个接口，并实现这个接口声明的方法，在这个过程其实会创建一个匿名内部类实现这个接口，并重写接口声明的方法，
 * 然后再创建一个这个匿名内部类的对象并赋值给前面的 OnClickListener 类型的引用；
 *
 * 2、new 一个已经存在的类 / 抽象类，并且选择性的实现这个类中的一个或者多个非 final 的方法，
 * 这个过程会创建一个匿名内部类对象继承对应的类 / 抽象类，并且重写对应的方法。
 *
 * 同样的，在匿名内部类中可以使用外部类的属性，但是外部类却不能使用匿名内部类中定义的属性，
 * 因为是匿名内部类，因此在外部类中无法获取这个类的类名，也就无法得到属性信息。
 */
public class AnonymousInnerClass {
    public int field1 = 1;
    protected int field2 = 2;
    int field3 = 3;
    private int field4 = 4;

    public AnonymousInnerClass() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    }
    // 自定义接口
    interface OnClickListener {
        void onClick(Object obj);
    }

    private void anonymousClassTest() {
        // 在这个过程中会新建一个匿名内部类对象，
        // 这个匿名内部类实现了 OnClickListener 接口并重写 onClick 方法
        OnClickListener clickListener = new OnClickListener() {
            // 可以在内部类中定义属性，但是只能在当前内部类中使用，
            // 无法在外部类中使用，因为外部类无法获取当前匿名内部类的类名，
            // 也就无法创建匿名内部类的对象
            int field = 1;

            @Override
            public void onClick(Object obj) {
                System.out.println("对象 " + obj + " 被点击");
                System.out.println("其外部类的 field1 字段的值为: " + field1);
                System.out.println("其外部类的 field2 字段的值为: " + field2);
                System.out.println("其外部类的 field3 字段的值为: " + field3);
                System.out.println("其外部类的 field4 字段的值为: " + field4);
            }
        };
        // new Object() 过程会新建一个匿名内部类，继承于 Object 类，
        // 并重写了 toString() 方法
        clickListener.onClick(new Object() {
            @Override
            public String toString() {
                return "obj1";
            }
        });
    }

    public static void main(String[] args) {
        AnonymousInnerClass outObj = new AnonymousInnerClass();
        outObj.anonymousClassTest();
    }

}
