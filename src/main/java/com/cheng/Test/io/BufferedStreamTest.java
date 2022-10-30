/*
 * ==============================================
 * (C)2018 Shanghai KingstarWinning Corporation. All rights reserved.
 * 项目名称： 规则引擎
 * 系统名称： ENGINE3.0
 * 文件名称： BufferedStreamTest.java
 * 注意事项：
 * Id: BufferedStreamTest.java,v3.0 2018/4/3 niecheng Exp
 * ==============================================
 */
package com.cheng.Test.io;

import java.io.*;

/**
 * <p>功能:字节缓存流测试 。</p>
 * <p>说明:无。</p>
 * <p>备注:无。</p>
 *
 *<pre>@author 公司名 : 上海金仕达卫宁软件科技有限公司（Shanghai KingStar WinningSoft LTD.）
 *         变更履历
 *         2018/4/3 : niecheng : 代码做成
 * @version 3.0</pre>
 */
public class BufferedStreamTest {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            fis = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/* Copyright (C) 2018, 上海金仕达卫宁软件科技有限公司 Project, All Rights Reserved. */