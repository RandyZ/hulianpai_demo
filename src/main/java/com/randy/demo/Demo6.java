package com.randy.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with demo.
 * Date: 2020/8/26.
 * Time: 9:24 下午.
 *
 * @author randy.
 */
public class Demo6 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime.parse("asdasdsd", DateTimeFormatter.ISO_DATE);
        now.format(DateTimeFormatter.ISO_DATE);
    }
}
