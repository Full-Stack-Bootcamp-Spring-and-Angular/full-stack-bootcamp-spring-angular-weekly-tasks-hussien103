package com.Example.Controller;

import com.Example.Models.Vehicle;
import com.Example.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BikeController implements VehicleController {
    @Autowired
    public DatabaseOperations databaseOperations;


    public BikeController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveToDatabase(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }


}
