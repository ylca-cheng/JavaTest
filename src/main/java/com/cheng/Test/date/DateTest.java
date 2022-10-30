package com.cheng.Test.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @Author:
 * @Date: 2020/12/14 10:54
 * @Version 1.0
 */
@Slf4j
public class DateTest {
    @Test
    public void test1(){
        Calendar lastDay = Calendar.getInstance();
        lastDay.set(2020,9,31);
        lastDay.add(Calendar.DATE,1);

        Calendar currDay = Calendar.getInstance();
        currDay.set(2020,11,11);

        int days = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) ;
        System.out.println(days);
        System.out.println(currDay.get(Calendar.DAY_OF_YEAR) - lastDay.get(Calendar.DAY_OF_YEAR));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(lastDay.getTime()));
    }

    /**
     * 测试时间戳
     */
    @Test
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time1 = 20211233L;
        Date date1 = new Date(time1);
        System.out.println(sdf.format(date1));

        long time2 = 0;
        Date date2 = new Date(time2);
        System.out.println(sdf.format(date2));
        log.info(sdf.format(date1));
    }

    @Test
    public void test3(){
        Date date1 = new Date(123);
        Date date2 = new Date(123);
        System.out.println(date1 == date2);
        System.out.println(Objects.hash(null,"123"));
    }

    @Test
    public void test4() throws Exception{
        String str = "99999999999999";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = sdf.parse(str);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime parse = LocalDateTime.parse(str, dtf);
        String format = dtf.format(parse);
        if (!format.equals(str)) {
            System.out.println("false");
        }else{
            System.out.println("true");
        }
        System.out.println(sdf.format(date));
    }
}
