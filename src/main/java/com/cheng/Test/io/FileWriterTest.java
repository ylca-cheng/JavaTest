/*
 * ==============================================
 * (C)2018 Shanghai KingstarWinning Corporation. All rights reserved.
 * 项目名称： 规则引擎
 * 系统名称： ENGINE3.0
 * 文件名称： FileWriterTest.java
 * 注意事项：
 * Id: FileWriterTest.java,v3.0 2018/4/2 niecheng Exp
 * ==============================================
 */
package com.cheng.Test.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>功能:使用FileWriter写入文件。</p>
 * <p>说明:无。</p>
 * <p>备注:无。</p>
 *
 * @author 公司名 : 上海金仕达卫宁软件科技有限公司（Shanghai KingStar WinningSoft LTD.） <br />
 *         变更履历 <br />
 *         2018/4/2 : niecheng : 代码做成<br />
 * @version 3.0
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 创建字符输入流
            fr = new FileReader("D:/test/test.txt");
            // 创建字符输出流
            fw = new FileWriter("D:/test/test1.txt");
            //创建一个长度为1024的竹筒
            char[] b = new char[1024];
            //用于保存的实际字节数
            int hasRead = 0;
            // 循环从输入流中取出数据
            while ((hasRead = fr.read(b)) > 0){
                fw.write(b,0,hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/* Copyright (C) 2018, 上海金仕达卫宁软件科技有限公司 Project, All Rights Reserved. */