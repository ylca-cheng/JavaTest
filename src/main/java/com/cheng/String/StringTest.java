package com.cheng.String;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by niecheng on 2019/5/5.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("abcd".substring(0,4));

        StringTest test = new StringTest();
        System.out.println(test.gcdOfStrings("ABCABCABC","ABCABC"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b){
        return b==0?a:gcd(b , a%b);
    }

    /**
     *
     * <p>@describe: 字符串长度测试</P>
     * <p>@param
     * <p>@return  </P>
     * <p>@date: 2020/4/22 14:31 </P>
     * <p>@author: niecheng </P>
     * <p>@remark:    </P>
     */
    @Test
    public void lenghTest() throws UnsupportedEncodingException {
        String str = "他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他他" ;
        System.out.println(str.getBytes("GBK").length);
    }

    @Test
    public void test2(){
        // 测试  startsWith
        System.out.println("DAFF".startsWith("D"));
        System.out.println(true & true);
        System.out.println(true & false & true);
    }

    @Test
    public void test3(){
        // 测试  字符串长度
        System.out.println("13835612356".length());
        System.out.println("张三1234567891234567891".length());
        System.out.println("1.0".length());
        System.out.println("预留".getBytes().length);
//        System.out.println(StringUtils.rightPad("369",8) + "--");
        System.out.println("预留".substring(0,"预留".getBytes().length));

    }

    @Test
    public void test4(){
        // 测试  字符串脱敏
        String addr = "上海市静安区宝华中心335号10楼";
        
        int len = addr.length()/2;
        System.out.println(StringUtils.rightPad(StringUtils.left(addr,len), StringUtils.length(addr),"*"));

        String card = "511321123456780431";
        System.out.println(StringUtils.left(card, 6)
                .concat(StringUtils.removeStart(
                        StringUtils.leftPad(StringUtils.right(card, 4), StringUtils.length(card), "*"),
                        "******")));

        String zdbm = "ICD.001";
        System.out.println(StringUtils.rightPad(StringUtils.left(zdbm,3), StringUtils.length(zdbm),"*"));
        System.out.println(zdbm.replaceAll("(\\w{3})\\w*","$1****"));

        String tel = "1234567";
        System.out.println(tel.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2"));

    }

    @Test
    public void test5(){
        String reportName = "达州2021年01月-2021年08月分析报告";
        String[] strs = reportName.split("-");
        System.out.println(strs[0].substring(2)+"-"+strs[1].substring(0,8));
        System.out.println(reportName.replaceAll("(\\d{2})", "$1"));
    }

    /**
     * 生成固定大小的文件
     */
    @Test
    public void test6() throws Exception {
       int lager = 500 * 1024 + 1;
        FileWriter fw = new FileWriter("C:\\Users\\niecheng\\Desktop\\500kb+1.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < lager; i++) {
            pw.print(" ");
        }
        pw.close();
    }

    @Test
    public void compareStr() throws IOException {

        String str1 = IOUtils.toString(new FileInputStream("C:\\Users\\niecheng\\Desktop\\str1.txt"),"utf-8");
        String str2 = IOUtils.toString(new FileInputStream("C:\\Users\\niecheng\\Desktop\\str2.txt"),"utf-8");

        for(int i= 1;i<str1.length();i++){
            if(!StringUtils.equals(str2.substring(0,i),str1.substring(0,i))){
                System.out.println("index:"+i);
                System.out.println("相同字符串："+str1.substring(0,i-1));
                System.out.println("不相同相同字符串："+str2.substring(i));
                return;
            }
        }
    }

    @Test
    public void getStrAscii(){
        System.out.println("adas");
    }

}
