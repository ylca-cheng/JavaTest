package com.atguigu.java8day1.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: niecheng
 * @Date: 2021/3/22 22:58
 * @Version 1.0
 *
 * lambda 表达式练习
 */
public class LambdaTest {

    /**
     * 调用Collections.sort()方法，通过制定排序比较两个Empoyeee对象，先按年龄，年龄相同再按姓名比较
     * 要求使用lambda 表达式
     */
    @Test
    public void test1(){
        Employee emp1 = new Employee(1,"张三",18,2000);
        Employee emp2 = new Employee(1,"李四",16,2000);

        List<Employee> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);

        emps.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compare(o2);
            }
        });

        emps.sort((x,y) -> x.compare(y));

        emps.sort(Employee::compare);

        for (Employee employee : emps){
            System.out.println(employee);
        }
    }

    /**
     * 声明一个函数式接口，String getValues(String str);
     * 使用lambda 表达式 将字符串转为大写
     * 截取字符串索引的2-4
     */
    @Test
    public void test2(){
        String str = "abcdefg";

        ChengFun fun2 = String::toUpperCase;
        System.out.println(fun2.getValues(str));

        ChengFun fun3 = new ChengFun() {
            @Override
            public String getValues(String str) {
                return str.substring(2,4);
            }
        };
        ChengFun fun4 = (x) -> x.substring(2,4);
        System.out.println(fun4.getValues(str));

        System.out.println(str.toUpperCase());
    }

    /**
     * 测试 map映射后 会产生新的元素，原有集合数据不变
     */
    @Test
    public void test3(){
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        // 所有数据 大写
        List<String> newList = strList.stream().map(String::toUpperCase).collect(Collectors.toList());

//        nums.stream().forEach(System.out::println);
        newList.forEach(System.out::println);
        System.out.println("===========");
        strList.forEach(System.out::println);
    }
}
