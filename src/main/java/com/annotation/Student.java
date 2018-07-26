package com.annotation;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {
    public void DiMethod() {
        System.out.println("这是测试di");
    }
}
