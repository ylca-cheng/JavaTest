package com.oop.innerclass;

/**
 * 内部类学习(成员内部类、局部内部类、匿名内部类、静态内部类)
 * 静态内部类
 *
 * 我们知道，一个类的静态成员独立于这个类的任何一个对象存在，只要在具有访问权限的地方，
 * 我们就可以通过 类名.静态成员名 的形式来访问这个静态成员，同样的，
 * 静态内部类也是作为一个外部类的静态成员而存在，创建一个类的静态内部类对象不需要依赖其外部类对象。
 */
public class StaticInnerClass {
    public int field1 = 1;

    public StaticInnerClass() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
        // 创建静态内部类对象
        StaticClass innerObj = new StaticClass();
        System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
        System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
        System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
        System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
    }

    static class StaticClass {

        public int field1 = 1;
        protected int field2 = 2;
        int field3 = 3;
        private int field4 = 4;
        // 静态内部类中可以定义 static 属性
        static int field5 = 5;

        public StaticClass() {
            System.out.println("创建 " + StaticClass.class.getSimpleName() + " 对象");
//            System.out.println("其外部类的 field1 字段的值为: " + field1); // 编译错误！！
        }
    }

    /**
     * 可以看到，静态内部类就像外部类的一个静态成员一样，创建其对象无需依赖外部类对象
     * （访问一个类的静态成员也无需依赖这个类的对象，因为它是独立于所有类的对象的）。
     * 但是于此同时，静态内部类中也无法访问外部类的非静态成员，因为外部类的非静态成员是属于每一个外部类对象的，
     * 而本身静态内部类就是独立外部类对象存在的，所以静态内部类不能访问外部类的非静态成员，
     * 而外部类依然可以访问静态内部类对象的所有访问权限的成员，这一点和普通内部类无异。
     * @param args
     */
    public static void main(String[] args) {
        // 无需依赖外部类对象，直接创建内部类对象
//        StaticInnerClass.StaticClass staticClassObj = new StaticInnerClass.StaticClass();
        StaticInnerClass outerObj = new StaticInnerClass();
    }
}
