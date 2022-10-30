package com.cheng.lang;

import org.junit.Test;

/**
 * @author
 * @Description 类描述
 * @date 2021/6/8 14:56
 */
public class SystemTest {
    @Test
    public void test(){
        // 当前项目文件路径
        String path = System.getProperty("user.dir");
        System.out.println(path);
    }
}
