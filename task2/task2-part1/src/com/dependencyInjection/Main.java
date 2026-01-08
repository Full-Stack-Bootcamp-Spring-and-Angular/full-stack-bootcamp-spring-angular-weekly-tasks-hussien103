package com.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle = context.getBean("circle" , Shape.class);
        circle.drawShape2d();
        circle.drawShape3d();
        Shape square = context.getBean("square" , Shape.class);
        square.drawShape2d();
        square.drawShape3d();

    }
}