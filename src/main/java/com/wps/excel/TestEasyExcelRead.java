package com.wps.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author niecheng
 * @Description 类描述
 * @date 2021/6/10 10:00
 */
public class TestEasyExcelRead {
    public static void main(String[] args) {

        //实现excel读操作
        String filename = "D:\\write.xlsx";
        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
    }
}
