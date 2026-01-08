package com.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle1 = context.getBean("circle" , Shape.class);
        Shape circle2= context.getBean("circle",Shape.class);
        System.out.println(circle1);
        System.out.println(circle2);
        Shape square1 = context.getBean("square" , Shape.class);
        Shape square2= context.getBean("square",Shape.class);
        System.out.println(square1);
        System.out.println(square2);
        ((ClassPathXmlApplicationContext) context).close();
    }
}