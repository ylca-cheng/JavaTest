package com.cheng.pattern;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @Description 类描述
 * @date 2021/6/17 17:50
 */
public class PatternTest {

    public static boolean match(String regx, String str) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(regx)) {
            return false;
        }
        return getMatcherByInsensitive(str, "^" + regx + "$").matches();
    }

    public static Matcher getMatcherByInsensitive(String str, String regx) {
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(str);
    }

    @Test
    public void test() {
        String regx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$";
        String str = "a66abb5684c45962d887564f08346e8d";
        System.out.println(match(regx, str));
        System.out.println(checkDateField("123"));
    }

    public static boolean checkDateField(String date) {
        String regx = "((\\d{3}[1-9]|\\d{2}[1-9]\\d|\\d[1-9]\\d{2}|[1-9]\\d{3})(((0[13578]|1[02])(0[1-9]|[12]\\d|3[01]))|((0[469]|11)(0[1-9]|[12]\\d|30))|(02(0[1-9]|[1]\\d|2[0-8]))))|(((\\d{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)";
        return match(regx, date);
    }

}
