package com.Example;

import com.Example.Controller.CarController;
import com.Example.Controller.PlaneController;
import com.Example.Controller.VehicleController;
import com.Example.Models.Type;
import com.Example.Models.Vehicle;
import com.Example.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Vehicle car1 = context.getBean("car", Vehicle.class);
        car1.setId(ThreadLocalRandom.current().nextInt(1, 10000)); // random int 1-9999

        car1.setModel("Toyota");
        car1.setType(Type.CAR);


        VehicleController carController = context.getBean("carController",VehicleController.class);
        carController.saveToDatabase(car1);

        Vehicle car2 = context.getBean("car", Vehicle.class);
        car2.setId(ThreadLocalRandom.current().nextInt(1, 10000)); // random int 1-9999

        car2.setModel("Corolla");
        car2.setType(Type.CAR);
        carController.saveToDatabase(car2);

        ((AnnotationConfigApplicationContext)context).close();
    }
}