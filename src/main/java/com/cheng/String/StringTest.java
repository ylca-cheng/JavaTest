package com.cheng.String;

import org.springframework.util.StringUtils;

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
}
