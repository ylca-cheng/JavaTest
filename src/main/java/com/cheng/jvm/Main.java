package com.cheng.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niecheng
 * @Date: 2020/7/23 10:35
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        while(true){
            demoList.add(new Demo());
        }
    }
}

class Demo{

}
