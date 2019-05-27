/*
 * ==============================================
 * (C)2018 Shanghai KingstarWinning Corporation. All rights reserved.
 * 项目名称： 规则引擎
 * 系统名称： ENGINE3.0
 * 文件名称： CollectionTest.java
 * 注意事项：
 * Id: CollectionTest.java,v3.0 2018/4/20 niecheng Exp
 * ==============================================
 */
package com.cheng.Test.collection;

import com.cheng.domain.User;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p>功能:集合测试。</p>
 * <p>说明:无。</p>
 * <p>备注:无。</p>
 * <p>
 * <pre>@version 3.0</pre>
 * <pre>@author 公司名 : 上海金仕达卫宁软件科技有限公司（Shanghai KingStar WinningSoft LTD.）
 *          变更履历
 *          2018/4/20 : niecheng : 代码做成</pre>
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<String>();
        books.add("a");
        books.add("b");
        books.add("c");
        books.add("d");
        for (String str :books) {
            System.out.println(str);
            if("c".equals(str)){
                str = "C";
            }
        }
        Iterator it = books.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test2(){
        Collection<User> users = new HashSet<User>();
        users.add(new User("a",1));
        users.add(new User("b",2));
        users.add(new User("c",3));
        users.add(new User("d",4));
        for(User user : users){
            System.out.println(user.toString());
            if("c".equals(user.getName())){
                user.setName("C");
            }
        }
        Iterator it = users.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void mapTest(){
        Map map = new HashMap();
        map.put("1",null);
        System.out.println(map.get("1"));
    }

    @Test
    public void listTest(){
        List<String> strings = new ArrayList<>();
        strings.add("1");
//        strings.addAll(null);
        System.out.println(strings.size());

        List<String> list1 = Collections.EMPTY_LIST;
        List<String> list2 = new ArrayList<>();
        list2.add("a");
//        if(list1.isEmpty()){
//            list1 = new ArrayList<>();
//        }
        System.out.println(list1.isEmpty());
        System.out.println(list2.isEmpty());
        System.out.println(CollectionUtils.isEmpty(list1));
        list1.addAll(list2);
        System.out.println(list1.contains("a"));
    }
}
/* Copyright (C) 2018, 上海金仕达卫宁软件科技有限公司 Project, All Rights Reserved. */