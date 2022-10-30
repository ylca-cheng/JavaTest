package com.oop.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Template<X,Y> {
    private X obj;

    public X getObj() {
        return obj;
    }

    public void setObj(X obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();

        // list1的引用类型是A或者A的父类
        // 那么自然可以往list1里放A及A的子类对象
        // 但是却不能放A的父类对象
        List<? super A> list1 = new ArrayList<>();
        list1.add(new A());
        list1.add(new B());
        list1.add(new C());
        // list1.add(new Object());

        // 接收只能用Object接收，因为不确定是哪个子类
        // 想要接收固定的子类只能做强制类型转发
        Object object = list1.get(0);


        // list2的引用类型是A的子类
        // 所以不能往里放任何对象，因为A可能有无数的子类，随便放一个万一类型不匹配呢
        // 不能放对象，但是接收的值就能很确定是A的子类
        List<? extends A> list2 = new ArrayList<>();
        // list2.add(new A());
        // list2.add(new ());

        // 接收的时候很明确是A或A的子类，所以都可以用A来接收
        A a = list2.get(0);
    }

    public void test(Function<X,Y> mapper){

    }
}
