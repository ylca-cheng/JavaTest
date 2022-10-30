package com.cheng.Test.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niecheng on 2019/12/26.
 */
public class MapTest {

    @Test
    public void mapTest(){
        Map<String,String> map = new HashMap();
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(111);
        }
    }

    @Test
    public void mapTest2(){
        Map<String,List<String>> map = new HashMap();
        List<String> list1 = new ArrayList<String>();
        list1.add("111");
        map.put("list1",list1);
        addStr(map.get("list1"));
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            List<String> strings = entry.getValue();
            for(String str : strings){
                System.out.println(str);
            }
        }
    }

    public int addStr(List<String> stringList){
        List<String> list = new ArrayList<String>();
        list.add("222");
//        stringList.addAll(list);
        list.addAll(stringList);
        return 1;
    }

    @Test
    public void mapTest3(){
        Map<String,String> map = new HashMap();
        map.put(null,"123");
        System.out.println(map.get(null));
    }
}
