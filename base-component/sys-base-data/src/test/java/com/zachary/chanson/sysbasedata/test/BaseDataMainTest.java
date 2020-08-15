package com.zachary.chanson.sysbasedata.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDataMainTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("sys-base-data:user-secret-8888"));
    }
}
