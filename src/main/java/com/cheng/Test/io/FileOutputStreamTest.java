/*
 * ==============================================
 * (C)2018 Shanghai KingstarWinning Corporation. All rights reserved.
 * 项目名称： 规则引擎
 * 系统名称： ENGINE3.0
 * 文件名称： FileOutputStreamTest.java
 * 注意事项：
 * Id: FileOutputStreamTest.java,v3.0 2018/4/2 niecheng Exp
 * ==============================================
 */
package com.cheng.Test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>功能:使用FileOutputStream写入文件。</p>
 * <p>说明:无。</p>
 * <p>备注:无。</p>
 *
 * @author 公司名 : 上海金仕达卫宁软件科技有限公司（Shanghai KingStar WinningSoft LTD.） <br />
 *         变更履历 <br />
 *         2018/4/2 : niecheng : 代码做成<br />
 * @version 3.0
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建字节输入流
            fis = new FileInputStream("D:/test/test.txt");
            // 创建字节输出流
            fos = new FileOutputStream("D:/test/newTest.txt");
            //创建一个长度为1024的竹筒
            byte[] b = new byte[1024];
            //用于保存的实际字节数
            int hasRead = 0;
            //循环从输入流中取出数据
            while ((hasRead = fis.read(b)) > 0){
                //每读取一次，即写入文件输入流，读了多少，就写多少。
                fos.write(b,0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/* Copyright (C) 2018, 上海金仕达卫宁软件科技有限公司 Project, All Rights Reserved. */