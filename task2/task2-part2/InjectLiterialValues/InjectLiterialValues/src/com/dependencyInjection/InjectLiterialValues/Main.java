package com.dependencyInjection.InjectLiterialValues;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Plane planeBean = context.getBean("planeBean" , Plane.class);
        planeBean.setBrand("beong");
        planeBean.saveToDatabase(planeBean);

        Car carBean = context.getBean("carBean" , Car.class);
        carBean.setBrand("Toyota");
        carBean.saveToDatabase(carBean);

    }
}