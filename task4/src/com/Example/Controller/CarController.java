package com.Example.Controller;

import com.Example.Models.Vehicle;
import com.Example.dao.DatabaseOperations;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CarController implements VehicleController {
    public DatabaseOperations databaseOperations;

    @Autowired
    public CarController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveToDatabase(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }


}
