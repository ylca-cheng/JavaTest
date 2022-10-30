package com.oop.innerclass;

import lombok.Data;

/**
 * 内部类学习(成员内部类、局部内部类、匿名内部类、静态内部类)
 *
 * 成员内部类
 * 什么情况下定义内部类？
 *
 * 1）为了隐藏并控制对这个类的访问
 *
 * 将内部类修饰为private，内部类就只能在外部类中去使用，在外部类以外不可见。
 *
 * 2）为了将一个类定义在另一个类的内部
 *
 * 当一个类依托另一个类而存在，无需单独定义java文件，可以将其定义为内部类。
 *
 * 3）借助内部类实现多继承
 *
 * Java是单继承语言，即一个类最多继承一个父类，如果每个内部类也继承一个父类，这样就间接实现了多继承
 */
@Data
public class MemberInnerClass {
    private int num;


    public int outField1 = 1;
    protected int outField2 = 2;
    int outField3 = 3;
    private int outField4 = 4;

    /**
     * 内部类
     * 可以用private修饰,这也是成员内部类的特点，如果是普通的类的话是不能用private修饰的
     * 用private修饰，则只能在外部类里面访问，外部类之外是不能访问的
     *
     * 两种创建内部类对象的方法
     * 1、在外部类的非静态方法中通过new去构造一个内部类对象
     * 2、外部类对象.new 内部类名称()
     */
    public MemberInnerClass() {
        // 在外部类对象内部，直接通过 new InnerClass(); 创建内部类对象
        InnerClassA innerObj = new InnerClassA();
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
        System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
        System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
        System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
        System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
    }

    public class InnerClassA {
        public int field1 = 5;
        protected int field2 = 6;
        int field3 = 7;
        private int field4 = 8;
//        static int field5 = 5; // 编译错误！普通内部类中不能定义 static 属性

        public InnerClassA() {
            System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
            System.out.println("其外部类的 outField1 字段的值为: " + outField1);
            System.out.println("其外部类的 outField2 字段的值为: " + outField2);
            System.out.println("其外部类的 outField3 字段的值为: " + outField3);
            System.out.println("其外部类的 outField4 字段的值为: " + outField4);
        }
    }

    /**
     * 我们注意到，内部类对象可以访问外部类对象中所有访问权限的字段，同时，外部类对象也可以通过内部类的对象引用来访问内部类中定义的所有访问权限的字段
     * @param args
     */
    public static void main(String[] args) {
        MemberInnerClass outerObj = new MemberInnerClass();
        // 不在外部类内部，使用：外部类对象. new 内部类构造器(); 的方式创建内部类对象
       // InnerClassA innerObj = outerObj.new InnerClassA();
    }
}
