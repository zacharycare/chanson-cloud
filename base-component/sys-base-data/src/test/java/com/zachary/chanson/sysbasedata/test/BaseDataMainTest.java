package com.zachary.chanson.sysbasedata.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDataMainTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
