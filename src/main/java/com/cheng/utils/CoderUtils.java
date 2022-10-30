package com.cheng.utils;

/**
 * @author niecheng
 * @Description 编码转换工具类
 * @date 2021/7/13 15:05
 */
public class CoderUtils {
    /**
     * ASCII码转中文
     *
     * @param ascii
     * @return
     */
    public static String ASCIItoString(String ascii) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] chars = ascii.split(" ");
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append((char) Integer.parseInt(chars[i]));
        }
        return stringBuffer.toString();
    }

    /**
     * 中文转ASCII码
     *
     * @param string
     * @return
     */
    public static String StringToASCII(String string) {
        //把字符中转换为字符数组
        char[] chars = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append((int) chars[i]);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    //Unicode转中文方法
    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    //中文转Unicode
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
    //测试
    public static void main(String[] args) {
        //Unicode码
//
//        #\u9519\u8bef\u7387\u8fbe\u523050\u5f00\u542f\u7194\u65ad\u4fdd\u62a4
        String aa = "\\u0023\\u9519\\u8bef\\u7387\\u8fbe\\u5230\\u0035\\u0030\\u5f00\\u542f\\u7194\\u65ad\\u4fdd\\u62a4";
        //转中文
        String cnAa = unicodeToCn(aa);
        System.out.println("Unicode转中文结果： "+cnAa);//转Unicode
        String unicodeAa = cnToUnicode(cnAa);
        System.out.println("中文转Unicode结果： "+unicodeAa);
    }

}
