package com.cheng.Test.collection;

import org.junit.Test;

import java.util.HashMap;
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
}
