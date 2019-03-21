package com.cheng.Test.io;

import com.cheng.domain.User;
import com.cheng.utils.SerializeUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by niecheng on 2018/3/28.
 */
public class SerializeTest {

    public static void main(String[] args) {
        // 创建用户对象
        User user = new User();
        user.setName("cheng");
        user.setAge(18);

        // 序列化对象
        byte[] result = SerializeUtil.serializeObject(user);
        System.out.println(result);

        // 反序列化
        User cheng = (User)SerializeUtil.deserializeObject(result);
        System.out.println(cheng);
    }
}
