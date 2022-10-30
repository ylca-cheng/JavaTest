package com.cheng.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author
 * @Description 类描述
 * @date 2021/4/14 15:43
 */
public class BeanUtilTest {

    /**
     * 测试 对象赋值 BeanUtils.setProperty为字符串数组赋值，会自动分割字符串
     */
    @Test
    public void test() throws Exception {
        User user = new User();
        String friends = "aaa:bbbbbb;cccc";
        BeanUtils.setProperty(user,"friends",friends);
        System.out.println(user);
    }

}
