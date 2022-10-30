package com.atguigu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static String[] strs = new String[] {"hello","www","pbteach","com"};

    public static void main(String[] args) {
        test2();
    }

    //传统方法每次处理生成一个新集合
    public static void test1() {

        //定义集合存放长度大于4的字符串
        List<String> list_filter =new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            //判断长度
            if(strs[i].length()>4) {
                list_filter.add(strs[i]);
            }
        }
        //定义集合存放转成大写字符的
        List<String> list_uppercase =new ArrayList<>();
        list_filter.forEach(x->{
            //转成大写
            String str_index = x.toUpperCase();
            list_uppercase.add(str_index);
        });
        //遍历list_uppercase集合
        list_uppercase.forEach(System.out::println);
    }

    public static void test2(){
        Stream.of(strs)//创建Stream流对象
                .filter(x->x.length()>4)//过滤字符串长度大于4的字符串
                .map(x->x.toUpperCase())//将字符串转成大写
                .forEach(System.out::println);//遍历每个字符串
    }
}
